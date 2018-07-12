package com.an9elkiss.api.user.service;

import java.util.List;

import com.an9elkiss.api.user.command.MenusCmd;
import com.an9elkiss.api.user.command.TokenCmd;
import com.an9elkiss.api.user.command.UserPersonCmd;
import com.an9elkiss.commons.command.ApiResponseCmd;

public interface AuthService {

	String QUERY_PARAM_USER_NAME = "name";
	String QUERY_PARAM_USER_PASSWORD = "password";
	String QUERY_PARAM_STATUS = "status";


	ApiResponseCmd<TokenCmd> login(String loginName, String password);

	ApiResponseCmd<MenusCmd> findMenus(String token);


	/**
	 * 返回當前token下属用户和下属用户的用户直到最下面
	 * @param token
	 * @return
	 */
	ApiResponseCmd<List<UserPersonCmd>> findUserPersonCmd(String token);
	
	/**
	 * 拿到所有人的信息
	 * @param token
	 * @return
	 */
	ApiResponseCmd<List<UserPersonCmd>> findAllPersonCmd(String token);
	

}
