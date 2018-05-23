package com.an9elkiss.api.user.constant;

public enum Role {
	ADMIN(1, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_TIME_DOMINATOR,
			ServiceRights.MENU_TIME_ENTRIES,
			ServiceRights.MENU_TIME_ENTRY_CHART}),

	DEFAULT(2, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_TIME_DOMINATOR,
			ServiceRights.MENU_TIME_ENTRIES,
			ServiceRights.MENU_TIME_ENTRY_CHART}),

	APP_USER_TIME_DOMINATOR(101, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_TIME_DOMINATOR,
			ServiceRights.MENU_TIME_ENTRIES,
			ServiceRights.MENU_TIME_ENTRY_CHART });
	
	private Integer roleId;
	private ServiceRights[] rights;
	
	private Role(Integer roleId, ServiceRights[] rights) {
		this.roleId = roleId;
		this.rights = rights;
	}
	
	public Integer getRoleId() {
		return roleId;
	}

	public ServiceRights[] getRights() {
		return rights;
	}

}
