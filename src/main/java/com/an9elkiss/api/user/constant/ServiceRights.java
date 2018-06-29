package com.an9elkiss.api.user.constant;

public enum ServiceRights {
	MENU_HOME(1,"菜单权限", 1, "首页", 1, 0),
	MENU_TIME_DOMINATOR(1,"菜单权限", 101, "时间管理", 1, 0),
	MENU_TIME_ENTRIES(1,"菜单权限", 102, "日程记录", 2, 101),
	MENU_TIME_ENTRY_CHART(1, "菜单权限", 103, "日程报表", 2, 101),
	MENU_SUPER_MANAGER(1, "菜单权限", 201, "任务管理", 1, 0),
	MENU_SUPERMNG_WEEK_TASKS(1, "菜单权限", 202, "一周任务", 2, 201),
	MENU_SUPERMNG_COED_REVIEW(1, "菜单权限", 203, "代码审核", 2, 201),
	MENU_SUPER_REPORT (1, "报表管理", 301, "任务管理", 1, 0),
    MENU_SUPERMNG_WEEK_PLAN(1, "菜单权限", 302, "一周计划", 2, 301),
    MENU_SUPERMNG_CONTRIBUTION(1, "菜单权限", 303, "贡献值", 2, 301),
    

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
	API_CODE_REVIEW_CREATE(2, "API权限", -1, null, -1, -1);
	
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
