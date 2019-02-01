package com.an9elkiss.api.user.constant;

public enum ServiceRights {
	MENU_HOME(1,"菜单权限", 1, "首页", 1, 0),
	
	MENU_TIME_DOMINATOR(1,"菜单权限", 101, "时间管理", 1, 0),
	MENU_TIME_ENTRIES(1,"菜单权限", 102, "日程记录", 2, 101),
	MENU_TIME_ENTRY_CHART(1, "菜单权限", 103, "日程报表", 2, 101),
	
	MENU_SUPER_MANAGER(1, "菜单权限", 201, "任务管理", 1, 0),
	MENU_SUPERMNG_WEEK_TASKS(1, "菜单权限", 202, "一周任务", 2, 201),
	MENU_SUPERMNG_COED_REVIEW(1, "菜单权限", 203, "代码审核", 2, 201),
	MENU_SUPERMNG_TASK_PLAN(1, "菜单权限", 204, "任务计划", 2, 201),
	
	MENU_SUPER_REPORT (1, "菜单权限", 301, "报表管理", 1, 0),
    MENU_SUPERMNG_WEEK_PLAN(1, "菜单权限", 302, "一周计划", 2, 301),
    MENU_SUPERMNG_CONTRIBUTION(1, "菜单权限", 303, "贡献值", 2, 301),
    MENU_SUPERMNG_REPORT_MANAGEMENT(1, "菜单权限", 304, "团队管理", 2, 301),
    
    MENU_SHARE(1, "菜单权限", 401, "培训分享", 1, 0),
    MENU_SHARE_SAVE(1, "菜单权限", 402, "我要分享", 2, 401),
    MENU_SHARE_SHOW(1, "菜单权限", 403, "分享列表", 2, 401),
    
    MENU_FILETREE(1, "菜单权限", 501, "文件管理", 1, 0),
    MENU_FILETREE_SHOW(1, "菜单权限", 502, "文件列表", 2, 501),
    

	API_WEEK_DAYS(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRY_NEW(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRY_GET(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRY_UPDATE(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRY_DEL(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRIES_GET(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRIES_DAILY(2, "API权限", -1, null, -1, -1),
	
	API_TASKS_GET(2, "API权限", -1, null, -1, -1),
	API_TASK_SAVE_POST(2, "API权限", -1, null, -1, -1),
	API_TASK_UPDATE_POST(2, "API权限", -1, null, -1, -1),
	API_TASK_GET(2, "API权限", -1, null, -1, -1),
	API_TASK_PARENTS(2, "API权限", -1, null, -1, -1),
	API_TASK_PARENT_RESOURCE(2, "API权限", -1, null, -1, -1),
	API_TASK_STATISTICAL_MAKE_BETTER(2, "API权限", -1, null, -1, -1),
	API_TASK_STATISTICAL_MAKE_BETTER_INFO(2, "API权限", -1, null, -1, -1),
	
	API_COMMON_TYPE(2, "API权限", -1, null, -1, -1),
	API_COMMON_YEAR_MONTH_WEEK(2, "API权限", -1, null, -1, -1),
	API_COMMON_WEEK_COUNT(2, "API权限", -1, null, -1, -1),
	
	API_TASK_WEEK_DEL(2, "API权限", -1, null, -1, -1),
	API_TASK_WEEK_COPY(2, "API权限", -1, null, -1, -1),
    API_TASK_SAVE_TAG_POST(2, "API权限", -1, null, -1, -1),
    API_CODE_REVIEW_INFO_GET(2, "API权限", -1, null, -1, -1),
    API_CODE_REVIEW_DELETE(2, "API权限", -1, null, -1, -1),
    API_CODE_REVIEW_UPDATE(2, "API权限", -1, null, -1, -1),
    API_CODE_REVIEW_GET(2, "API权限", -1, null, -1, -1),
	API_CODE_REVIEW_CREATE(2, "API权限", -1, null, -1, -1),
	API_CODE_REVIEW_STATISTICAL_GROUP(2, "API权限", -1, null, -1, -1),
	API_CODE_REVIEW_STATISTICAL_GROUP_INFO(2, "API权限", -1, null, -1, -1),
	
	API_SHARE_SAVE_POST(2, "API权限", -1, null, -1, -1),
	API_SHARE_SHOW(2, "API权限", -1, null, -1, -1),
	API_SHARECOMMENT(2, "API权限", -1, null, -1, -1),
	API_FINDSHARECOMMENT(2, "API权限", -1, null, -1, -1),
	API_SHAREPRAISE(2, "API权限", -1, null, -1, -1),
	API_SHARE_DOWNLOADFILE(2, "API权限", -1, null, -1, -1),
	API_SHARE_DELETE(2, "API权限", -1, null, -1, -1),
	API_SHARE_UPDATE(2, "API权限", -1, null, -1, -1),
	API_SHARE_STATISTICAL_GROUP(2, "API权限", -1, null, -1, -1),
	API_SHARE_STATISTICAL_GROUP_INFO(2, "API权限", -1, null, -1, -1),
	
	API_FILETREE_SAVE(2, "API权限", -1, null, -1, -1),
	API_FILETREE_FINDALL(2, "API权限", -1, null, -1, -1),
	API_FILETREE_FIND(2, "API权限", -1, null, -1, -1),
	API_FILETREE_DELETE(2, "API权限", -1, null, -1, -1),
	API_FILETREE_UPEATE(2, "API权限", -1, null, -1, -1),
	API_FILETREE_UPLOADFILE(2, "API权限", -1, null, -1, -1),
	
	API_SAVE_PROJECTPLANTRACKING(2, "API权限", -1, null, -1, -1),
	API_UPDATE_PROJECTPLANTRACKING(2, "API权限", -1, null, -1, -1),
	API_DELETE_PROJECTPLANTRACKING(2, "API权限", -1, null, -1, -1),
	API_FIND_PROJECTPLANTRACKINGS(2, "API权限", -1, null, -1, -1),
	API_FIND_PROJECTPLANTRACKINGCMDS(2, "API权限", -1, null, -1, -1),
	API_SAVE_PROJECTPLANPHASE(2, "API权限", -1, null, -1, -1),
	API_UPDATE_PROJECTPLANPHASE(2, "API权限", -1, null, -1, -1),
	API_DELETE_PROJECTPLANPHASE(2, "API权限", -1, null, -1, -1),
	API_SAVE_PROJECTPLANPHASECHECK(2, "API权限", -1, null, -1, -1),
	API_UPDATE_PROJECTPLANPHASECHECK(2, "API权限", -1, null, -1, -1),
	API_DELETE_PROJECTPLANPHASECHECK(2, "API权限", -1, null, -1, -1),
	
	
	;
	
	
	private Integer typeId;
	private String typeName;
	private Integer menuId;
	private String menuName;
	private Integer menuLevel;
	private Integer parentMenuId;
	
	private ServiceRights(Integer typeId, String typeName, Integer menuId, String menuName, Integer menuLevel, Integer parentMenuId) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuLevel = menuLevel;
		this.parentMenuId = parentMenuId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public Integer getParentMenuId() {
		return parentMenuId;
	}
	
	
	
	
	
}
