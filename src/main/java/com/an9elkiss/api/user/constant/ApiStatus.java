package com.an9elkiss.api.user.constant;

import com.an9elkiss.commons.command.Status;

public enum ApiStatus implements Status {
	
	// --生命周期----------------------------
	NEW(1, "新建"),
	ACTIVE(11, "生效"),
	FORBIDDEN(12, "禁用"),
	DELETED(21, "已删除"),

	// --Http Response----------------------------
	SUCCESS(200, "操作成功"),

	NOT_FOUND(401, "未找到数据"),
	
	// --User API----------------------------
	USER_NAME_OR_PASSWORD_EMPTY(500101, "用户名或密码为空！"),
	LOGIN_FAIL(500102, "用户名或密码错误..."),
	RESET_PASSWORD_OLD_PASSWORD_ERR(500103, "请注意：旧密码错误"),
	RESET_PASSWORD_LESS_THAN_SIX(500104, "请注意：密码必须大于6位"),
	RESET_PASSWORD_ERR(500105, "请注意：修改密码异常"),
	RESET_PASSWORD_NEW_PASSWORD_DIFFERENT(500106, "请注意：新密码与第二次输入的密码不同"),
	RESET_PASSWORD_REGULAR_MATCH(500107, "请注意：新密码必须由数字、字母、特殊符号组成"),
	;
	
	private Integer code;
	private String message;

	private ApiStatus(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public Integer getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public boolean is(Integer code) {
		return this.code.equals(code);
	}

}
