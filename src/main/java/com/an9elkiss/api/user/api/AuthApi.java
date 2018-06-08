/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.12-1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.an9elkiss.api.user.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.an9elkiss.api.user.command.MenusCmd;
import com.an9elkiss.api.user.command.TokenCmd;
import com.an9elkiss.api.user.command.UserPersonCmd;
import com.an9elkiss.commons.command.ApiResponseCmd;



public interface AuthApi {

	ResponseEntity<ApiResponseCmd<TokenCmd>> login(
			@RequestParam(value = "loginName", required = true) String loginName,
			@RequestParam(value = "password", required = true) String password);

	ResponseEntity<ApiResponseCmd<MenusCmd>> findMenus(@RequestParam(value = "token", required = true) String token);

	ResponseEntity<ApiResponseCmd<List<UserPersonCmd>>> findPersons(@RequestParam(value = "token", required = true) String token);

}
