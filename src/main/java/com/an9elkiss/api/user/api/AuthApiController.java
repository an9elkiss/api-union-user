package com.an9elkiss.api.user.api;


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
import com.an9elkiss.api.user.service.AuthService;
import com.an9elkiss.commons.command.ApiResponseCmd;

@Controller
public class AuthApiController implements AuthApi {

	private static final Logger log = LoggerFactory.getLogger(AuthApiController.class);

	@Autowired
	private AuthService authService;

    @Override
	@RequestMapping(value = "/login", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<ApiResponseCmd<TokenCmd>> login(
			@RequestParam(value = "loginName", required = true) String loginName,
			@RequestParam(value = "password", required = true) String password) {

		return ResponseEntity.ok(authService.login(loginName, password));
    }

	@Override
	@RequestMapping(value = "/menus", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<ApiResponseCmd<MenusCmd>> findMenus(
			@RequestParam(value = "token", required = true) String token) {

		return ResponseEntity.ok(authService.findMenus(token));
	}


}
