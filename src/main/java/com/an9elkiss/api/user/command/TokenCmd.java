package com.an9elkiss.api.user.command;

import java.util.UUID;

public class TokenCmd {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static TokenCmd random() {
		TokenCmd tokenCmd = new TokenCmd();
		tokenCmd.setToken(UUID.randomUUID().toString());

		return tokenCmd;
	}

}
