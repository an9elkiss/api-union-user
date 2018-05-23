package com.an9elkiss.api.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.an9elkiss.api.user.command.TokenCmd;
import com.an9elkiss.api.user.command.UserCmd;
import com.an9elkiss.api.user.constant.ApiStatus;
import com.an9elkiss.api.user.dao.UserDao;
import com.an9elkiss.commons.command.ApiResponseCmd;
import com.an9elkiss.commons.util.MapUtils;

@Service
public class AuthServiceImpl implements AuthService {

	private final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	public ApiResponseCmd<TokenCmd> login(String loginName, String password) {
		
		if(StringUtils.isBlank(loginName) || StringUtils.isBlank(password)){
			return new ApiResponseCmd(ApiStatus.USER_NAME_OR_PASSWORD_EMPTY);
		}
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
		MapUtils.addIfNotBlank(searchParams, AuthService.QUERY_PARAM_USER_NAME, loginName);
		MapUtils.addIfNotBlank(searchParams, AuthService.QUERY_PARAM_USER_PASSWORD, password);
		MapUtils.addIfNotBlank(searchParams, AuthService.QUERY_PARAM_STATUS, ApiStatus.ACTIVE.getCode());
		
		List<UserCmd> users = userDao.findUsers(searchParams);
		if (users == null || users.isEmpty()) {
			return new ApiResponseCmd(ApiStatus.LOGIN_FAIL);
		} else if (users.size() > 1) {
			logger.warn("用户登录，查询用户异常！size > 1, loginName = %s", loginName);
			return new ApiResponseCmd(ApiStatus.LOGIN_FAIL);
		}


		// TODO to redis
		TokenCmd tokenCmd = TokenCmd.random();

		return ApiResponseCmd.success(tokenCmd);
	}







}
