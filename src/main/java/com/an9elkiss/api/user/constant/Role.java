package com.an9elkiss.api.user.constant;

public enum Role {
	ADMIN(1, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_TIME_DOMINATOR,
			ServiceRights.MENU_TIME_ENTRIES,
			ServiceRights.MENU_TIME_ENTRY_CHART,
			
			ServiceRights.MENU_SUPER_MANAGER,
			ServiceRights.MENU_SUPERMNG_WEEK_TASKS,
			ServiceRights.MENU_SUPERMNG_COED_REVIEW,
			ServiceRights.MENU_SUPER_REPORT,
			ServiceRights.MENU_SUPERMNG_WEEK_PLAN,
			ServiceRights.MENU_SUPERMNG_CONTRIBUTION,
			ServiceRights.MENU_SUPERMNG_REPORT_MANAGEMENT,
			
			ServiceRights.MENU_SHARE,
			ServiceRights.MENU_SHARE_SAVE,
			ServiceRights.MENU_SHARE_SHOW,
			
			ServiceRights.MENU_FILETREE,
			ServiceRights.MENU_FILETREE_SHOW,
			
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
			ServiceRights.API_TASK_SAVE_TAG_POST,
			ServiceRights.API_TASK_STATISTICAL_MAKE_BETTER,
			ServiceRights.API_TASK_STATISTICAL_MAKE_BETTER_INFO,
			
			ServiceRights.API_CODE_REVIEW_CREATE,
			ServiceRights.API_CODE_REVIEW_GET,
			ServiceRights.API_CODE_REVIEW_INFO_GET,
			ServiceRights.API_CODE_REVIEW_DELETE,
			ServiceRights.API_CODE_REVIEW_UPDATE,
			ServiceRights.API_CODE_REVIEW_STATISTICAL_GROUP,
			ServiceRights.API_CODE_REVIEW_STATISTICAL_GROUP_INFO,
			
			ServiceRights.API_SHARE_SAVE_POST,
			ServiceRights.API_SHARE_SHOW,
			ServiceRights.API_SHARECOMMENT,
			ServiceRights.API_FINDSHARECOMMENT,
			ServiceRights.API_SHAREPRAISE,
			ServiceRights.API_SHARE_DOWNLOADFILE,
			ServiceRights.API_SHARE_DELETE,
			ServiceRights.API_SHARE_UPDATE,
			ServiceRights.API_SHARE_STATISTICAL_GROUP,
			ServiceRights.API_SHARE_STATISTICAL_GROUP_INFO,
			
			ServiceRights.API_FILETREE_SAVE,
			ServiceRights.API_FILETREE_FINDALL,
			ServiceRights.API_FILETREE_FIND,
			ServiceRights.API_FILETREE_DELETE,
			ServiceRights.API_FILETREE_UPEATE,
			ServiceRights.API_FILETREE_UPLOADFILE
	}),

	DEFAULT(2, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_TIME_DOMINATOR,
			ServiceRights.MENU_TIME_ENTRIES,
			ServiceRights.MENU_TIME_ENTRY_CHART,
			ServiceRights.API_WEEK_DAYS}),

	APP_USER_TIME_DOMINATOR(101, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_TIME_DOMINATOR,
			ServiceRights.MENU_TIME_ENTRIES,
			ServiceRights.MENU_TIME_ENTRY_CHART,
			ServiceRights.API_WEEK_DAYS }),
	
	APP_USER_SUPER_MANAGER(201, new ServiceRights[] { ServiceRights.MENU_HOME,
			ServiceRights.MENU_SUPER_MANAGER,
			ServiceRights.MENU_SUPERMNG_WEEK_TASKS,
			ServiceRights.MENU_TIME_ENTRY_CHART,
			ServiceRights.MENU_SUPERMNG_COED_REVIEW,
            ServiceRights.MENU_SUPER_REPORT,
            ServiceRights.MENU_SUPERMNG_WEEK_PLAN,
            ServiceRights.MENU_SUPERMNG_CONTRIBUTION,
            ServiceRights.MENU_SUPERMNG_REPORT_MANAGEMENT,
            ServiceRights.MENU_SHARE,
			ServiceRights.MENU_SHARE_SAVE,
			ServiceRights.MENU_SHARE_SHOW,
			ServiceRights.MENU_FILETREE,
			ServiceRights.MENU_FILETREE_SHOW,
			
            
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
			ServiceRights.API_TASK_STATISTICAL_MAKE_BETTER_INFO,
			ServiceRights.API_CODE_REVIEW_STATISTICAL_GROUP_INFO,
			
			ServiceRights.API_SHARE_SAVE_POST,
			ServiceRights.API_SHARE_SHOW,
			ServiceRights.API_SHARECOMMENT,
			ServiceRights.API_FINDSHARECOMMENT,
			ServiceRights.API_SHAREPRAISE,
			ServiceRights.API_SHARE_DOWNLOADFILE,
			ServiceRights.API_SHARE_DELETE,
			ServiceRights.API_SHARE_UPDATE,
			ServiceRights.API_SHARE_STATISTICAL_GROUP_INFO,
			
			ServiceRights.API_FILETREE_SAVE,
			ServiceRights.API_FILETREE_FINDALL,
			ServiceRights.API_FILETREE_FIND,
			ServiceRights.API_FILETREE_DELETE,
			ServiceRights.API_FILETREE_UPEATE,
			ServiceRights.API_FILETREE_UPLOADFILE
	});
	
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
			if (role.getRoleId().equals(id)) {
				return role;
			}
		}
		return null;
	}

}
