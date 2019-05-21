package com.an9elkiss.api.user.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.an9elkiss.api.user.command.MenusCmd;
import com.an9elkiss.api.user.command.TokenCmd;
import com.an9elkiss.api.user.command.UserPersonCmd;
import com.an9elkiss.api.user.constant.ApiStatus;
import com.an9elkiss.api.user.service.AuthService;
import com.an9elkiss.commons.auth.spring.Access;
import com.an9elkiss.commons.command.ApiResponseCmd;

@Controller
public class AuthApiController implements AuthApi{

    private static final Logger log = LoggerFactory.getLogger(AuthApiController.class);

    @Autowired
    private AuthService authService;

    @Override
    @RequestMapping(value = "/login",produces = { "application/json" },method = RequestMethod.POST)
    public ResponseEntity<ApiResponseCmd<TokenCmd>> login(@RequestParam(value = "loginName",required = true) String loginName,@RequestParam(value = "password",required = true) String password){

        return ResponseEntity.ok(authService.login(loginName, password));
    }

    @Override
    @RequestMapping(value = "/menus",produces = { "application/json" },method = RequestMethod.GET)
    public ResponseEntity<ApiResponseCmd<MenusCmd>> findMenus(@RequestParam(value = "token",required = true) String token){

        return ResponseEntity.ok(authService.findMenus(token));
    }

    @Override
    @RequestMapping(value = "/persons",produces = { "application/json" },method = RequestMethod.GET)
    public ResponseEntity<ApiResponseCmd<List<UserPersonCmd>>> findPersons(@RequestParam(value = "token",required = true) String token){

        return ResponseEntity.ok(authService.findUserPersonCmd(token));
    }

    @Override
    @RequestMapping(value = "/allPersons",produces = { "application/json" },method = RequestMethod.GET)
    public ResponseEntity<ApiResponseCmd<List<UserPersonCmd>>> findAllPersons(String token){
        return ResponseEntity.ok(authService.findAllPersonCmd(token));
    }

    @Override
    @Access("API_RESET_PASSWORD")
    @RequestMapping(value = "/reset/password",produces = { "application/json" },method = RequestMethod.POST)
    public ResponseEntity<ApiResponseCmd<Object>> resetPassword(
                    @RequestParam(value = "oldPassword",required = true) String oldPassword,
                    @RequestParam(value = "newPassword",required = true) String newPassword,
                    @RequestParam(value = "repeatNewPassword",required = true) String repeatNewPassword,
                    @RequestParam(value = "token",required = true) String token){
        if (checkPasswordLength(oldPassword, newPassword, repeatNewPassword)){
            log.info("用户重置密码时，位数小于6位");
            return ResponseEntity.ok(new ApiResponseCmd<>(ApiStatus.RESET_PASSWORD_LESS_THAN_SIX));
        }
        return ResponseEntity.ok(authService.resetPassword(oldPassword, newPassword, repeatNewPassword,token));
    }

    private boolean checkPasswordLength(String oldPassword,String newPassword,String repeatNewPassword){
        if (oldPassword.length() > 6 && newPassword.length() > 6 && repeatNewPassword.length() > 6){
            return true;
        }
        return false;
    }

}
