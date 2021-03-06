package com.an9elkiss.api.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.an9elkiss.api.user.command.MenuCmd;
import com.an9elkiss.api.user.command.MenusCmd;
import com.an9elkiss.api.user.command.TokenCmd;
import com.an9elkiss.api.user.command.UserCmd;
import com.an9elkiss.api.user.command.UserPersonCmd;
import com.an9elkiss.api.user.constant.ApiStatus;
import com.an9elkiss.api.user.constant.Role;
import com.an9elkiss.api.user.constant.ServiceRights;
import com.an9elkiss.api.user.dao.UserDao;
import com.an9elkiss.api.user.util.MD5Utils;
import com.an9elkiss.api.user.util.PasswordRegularMatchUtils;
import com.an9elkiss.commons.auth.JsonFormater;
import com.an9elkiss.commons.auth.model.ApiRights;
import com.an9elkiss.commons.auth.model.MenuRights;
import com.an9elkiss.commons.auth.model.Principal;
import com.an9elkiss.commons.auth.model.Rights;
import com.an9elkiss.commons.auth.model.User;
import com.an9elkiss.commons.command.ApiResponseCmd;
import com.an9elkiss.commons.constant.RedisKeyPrefix;
import com.an9elkiss.commons.util.JsonUtils;
import com.an9elkiss.commons.util.MapUtils;
import com.an9elkiss.commons.util.spring.RedisUtils;

@Service
public class AuthServiceImpl implements AuthService{

    private final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public ApiResponseCmd<TokenCmd> login(String loginName,String password){

        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password)){
            return new ApiResponseCmd(ApiStatus.USER_NAME_OR_PASSWORD_EMPTY);
        }

        Map<String, Object> searchParams = new HashMap<String, Object>();
        MapUtils.addIfNotBlank(searchParams, AuthService.QUERY_PARAM_USER_NAME, loginName);
        MapUtils.addIfNotBlank(searchParams, AuthService.QUERY_PARAM_USER_PASSWORD, MD5Utils.md5DigestAsHex(password));
        MapUtils.addIfNotBlank(searchParams, AuthService.QUERY_PARAM_STATUS, ApiStatus.ACTIVE.getCode());

        List<UserCmd> users = userDao.findUsers(searchParams);
        if (users == null || users.isEmpty()){
            return new ApiResponseCmd(ApiStatus.LOGIN_FAIL);
        }else if (users.size() > 1){
            logger.warn("用户登录，查询用户异常！size > 1, loginName = %s", loginName);
            return new ApiResponseCmd(ApiStatus.LOGIN_FAIL);
        }

        Principal principal = buildPrincipal(users.get(0));
        String json = JsonUtils.toString(principal);

        TokenCmd tokenCmd = TokenCmd.random();
        tokenCmd.setUserName(principal.getName());
        tokenCmd.setId(principal.getId());
        redisUtils.setString(RedisKeyPrefix.SESSION + tokenCmd.getToken(), json, 60l, TimeUnit.MINUTES);

        return ApiResponseCmd.success(tokenCmd);
    }

    private Principal buildPrincipal(UserCmd userCmd){
        User user = new User();
        BeanUtils.copyProperties(userCmd, user);

        List<Rights> rightList = new ArrayList<Rights>();

        Integer roleId = userCmd.getRoleId();
        Role role = Role.byId(roleId);
        for (ServiceRights rights : role.getRights()){
            if (rights.getTypeId() == MenuRights.TYPE_ID){
                MenuRights r = new MenuRights();
                BeanUtils.copyProperties(rights, r);
                r.setCode(rights.name());
                r.setRoleId(role.getRoleId());
                r.setRoleCode(role.name());
                rightList.add(r);
            }else if (rights.getTypeId() == ApiRights.TYPE_ID){
                ApiRights r = new ApiRights();
                BeanUtils.copyProperties(rights, r);
                r.setCode(rights.name());
                r.setRoleId(role.getRoleId());
                r.setRoleCode(role.name());
                rightList.add(r);
            }
        }

        return new Principal(user, rightList);
    }

    @Override
    public ApiResponseCmd<MenusCmd> findMenus(String token){

        String json = redisUtils.getString(RedisKeyPrefix.SESSION + token);
        if (StringUtils.isBlank(json)){
            return ApiResponseCmd.success(new MenusCmd());
        }
        Principal principal = JsonFormater.format(json);

        MenusCmd menus = new MenusCmd();
        for (Rights r : principal.getRights()){
            if (r instanceof MenuRights){
                MenuRights mr = (MenuRights) r;
                MenuCmd menuCmd = new MenuCmd();
                BeanUtils.copyProperties(mr, menuCmd);
                menus.getMenus().add(menuCmd);
            }
        }

        return ApiResponseCmd.success(menus);
    }

    @Override
    public ApiResponseCmd<List<UserPersonCmd>> findUserPersonCmd(String token){
        Principal principal = getPrincipal(token);

        // 查询全部用户
        List<UserPersonCmd> findUserPerson = userDao.findUserPerson();
        Map<Integer, UserPersonCmd> userPersonCmdMap = new HashMap<>();

        // leadid为key 下属为velue
        Map<Integer, List<UserPersonCmd>> leadMap = new HashMap<>();
        for (UserPersonCmd userPersonCmd : findUserPerson){
            userPersonCmdMap.put(userPersonCmd.getUserId(), userPersonCmd);
            if (leadMap.get(userPersonCmd.getLeadId()) != null){
                leadMap.get(userPersonCmd.getLeadId()).add(userPersonCmd);
            }else{
                List<UserPersonCmd> list = new ArrayList<UserPersonCmd>();
                list.add(userPersonCmd);
                leadMap.put(userPersonCmd.getLeadId(), list);
            }
        }

        // 当前用户
        UserPersonCmd currentUser = userPersonCmdMap.get(principal.getSubject().getId());

        // 该用户下属
        List<UserPersonCmd> list = leadMap.get(currentUser.getUserId());

        // 表示他不是领导
        if (list == null){
            list = new ArrayList<UserPersonCmd>();
            list.add(currentUser);
            return ApiResponseCmd.success(list);
        }

        // 他是领导时
        // 最终返回的list
        List<UserPersonCmd> users = new ArrayList<>();
        users.add(currentUser);
        recursiveUserPerson(users, list, leadMap);
        return ApiResponseCmd.success(users);
    }

    private void recursiveUserPerson(List<UserPersonCmd> users,List<UserPersonCmd> list,Map<Integer, List<UserPersonCmd>> leadMap){
        users.addAll(list);
        for (UserPersonCmd userPersonCmd : list){
            List<UserPersonCmd> listz = leadMap.get(userPersonCmd.getUserId());
            if (null != listz && listz.size() > 0){
                recursiveUserPerson(users, listz, leadMap);
            }
        }
    }

    @Override
    public ApiResponseCmd<List<UserPersonCmd>> findAllPersonCmd(String token){
        String json = redisUtils.getString(RedisKeyPrefix.SESSION + token);
        if (StringUtils.isBlank(json)){
            return ApiResponseCmd.deny();
        }
        //		Principal principal = JsonFormater.format(json);

        // 查询全部用户
        List<UserPersonCmd> findUserPerson = userDao.findUserPerson();
        return ApiResponseCmd.success(findUserPerson);
    }

    @Override
    public ApiResponseCmd<Object> resetPassword(String oldPassword,String newPassword,String repeatNewPassword,String token){

        Principal principal = getPrincipal(token);

        if (principal == null){
            logger.debug("用户令牌无效");
            return ApiResponseCmd.deny();
        }

        if (!newPassword.equals(repeatNewPassword)){
            logger.info("新密码与第二次输入的密码不同");
            return new ApiResponseCmd<>(ApiStatus.RESET_PASSWORD_NEW_PASSWORD_DIFFERENT);
        }
        
        if(!PasswordRegularMatchUtils.regularMatchPassword(newPassword)){
            logger.info("新密码不符合复杂度校验");
            return new ApiResponseCmd<>(ApiStatus.RESET_PASSWORD_REGULAR_MATCH);
        }

        String oldPasswordMD5 = MD5Utils.md5DigestAsHex(oldPassword);

        Map<String, Object> searchParams = new HashMap<String, Object>();
        MapUtils.addIfNotBlank(searchParams, AuthService.QUERY_PARAM_USER_NAME, principal.getSubject().getName());
        MapUtils.addIfNotBlank(searchParams, AuthService.QUERY_PARAM_USER_PASSWORD, oldPasswordMD5);
        MapUtils.addIfNotBlank(searchParams, AuthService.QUERY_PARAM_STATUS, ApiStatus.ACTIVE.getCode());

        List<UserCmd> users = userDao.findUsers(searchParams);

        if (users == null || users.isEmpty()){
            logger.info("用户重置密码时，输入密码错误");
            return new ApiResponseCmd(ApiStatus.RESET_PASSWORD_OLD_PASSWORD_ERR);
        }else if (users.size() > 1){
            logger.warn("用户重置密码，查询用户异常！size > 1, userName = %s", principal.getSubject().getName());
            return new ApiResponseCmd(ApiStatus.RESET_PASSWORD_ERR);
        }

        userDao.updatePassword(new UserCmd(users.get(0).getId(), MD5Utils.md5DigestAsHex(newPassword)));

        return ApiResponseCmd.success();
    }

    private Principal getPrincipal(String token){
        String json = redisUtils.getString(RedisKeyPrefix.SESSION + token);
        if (StringUtils.isBlank(json)){
            return null;
        }

        Principal principal = JsonFormater.format(json);
        return principal;
    }
}
