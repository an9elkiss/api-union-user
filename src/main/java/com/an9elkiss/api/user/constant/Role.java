package com.an9elkiss.api.user.constant;

public enum Role {
	ADMIN(1, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_TIME_DOMINATOR,
			ServiceRights.MENU_TIME_ENTRIES,
			ServiceRights.MENU_TIME_ENTRY_CHART,
			ServiceRights.API_TIME_ENTRY_NEW,
			ServiceRights.API_TIME_ENTRY_GET,
			ServiceRights.API_TIME_ENTRY_UPDATE,
			ServiceRights.API_TIME_ENTRY_DEL,
			ServiceRights.API_TIME_ENTRIES_GET,
			ServiceRights.API_TIME_ENTRIES_DAILY,
			ServiceRights.API_WEEK_DAYS,
			ServiceRights.API_TASKS_GET,
			ServiceRights.API_TASK_SAVE_POST,
			ServiceRights.API_TASK_UPDATE_POST,
			ServiceRights.API_TASK_GET,
			ServiceRights.API_TASK_PARENTS,
			ServiceRights.API_TASK_PARENT_RESOURCE,
			ServiceRights.API_COMMON_TYPE,
			ServiceRights.API_COMMON_YEAR_MONTH_WEEK,
			ServiceRights.API_COMMON_WEEK_COUNT,
			ServiceRights.API_TASK_WEEK_DEL,
			ServiceRights.API_TASK_WEEK_COPY,
			ServiceRights.API_TASK_SAVE_TAG_POST}),

	DEFAULT(2, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_TIME_DOMINATOR,
			ServiceRights.MENU_TIME_ENTRIES,
			ServiceRights.MENU_TIME_ENTRY_CHART,
			ServiceRights.API_WEEK_DAYS}),

	APP_USER_TIME_DOMINATOR(101, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_TIME_DOMINATOR,
			ServiceRights.MENU_TIME_ENTRIES,
			ServiceRights.MENU_TIME_ENTRY_CHART,
			ServiceRights.API_WEEK_DAYS });
	
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

	public static Role byId(Integer id) {
		for(Role role : Role.values()){
			if(role.getRoleId() == id){
				return role;
			}
		}
		return null;
	}

}
