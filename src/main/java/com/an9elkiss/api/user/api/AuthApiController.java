package com.an9elkiss.api.user.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.an9elkiss.api.user.api.command.TokenCmd;
import com.an9elkiss.commons.command.ApiResponseCmd;

@Controller
public class AuthApiController implements AuthApi {

	private static final Logger log = LoggerFactory.getLogger(AuthApiController.class);



    @Override
	@RequestMapping(value = "/login", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<ApiResponseCmd<TokenCmd>> login(
			@RequestParam(value = "loginName", required = true) String loginName,
			@RequestParam(value = "password", required = true) String password) {

		// TODO
		TokenCmd token = new TokenCmd();
		token.setToken("aaaaaaa");
		ApiResponseCmd<TokenCmd> cmd = ApiResponseCmd.success(token);

		return ResponseEntity.ok(cmd);
    }


}
