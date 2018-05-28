package com.an9elkiss.api.user.service;

import com.an9elkiss.api.user.command.MenusCmd;
import com.an9elkiss.api.user.command.TokenCmd;
import com.an9elkiss.commons.command.ApiResponseCmd;

public interface AuthService {

	String QUERY_PARAM_USER_NAME = "name";
	String QUERY_PARAM_USER_PASSWORD = "password";
	String QUERY_PARAM_STATUS = "status";


	ApiResponseCmd<TokenCmd> login(String loginName, String password);

	ApiResponseCmd<MenusCmd> findMenus(String token);


}
