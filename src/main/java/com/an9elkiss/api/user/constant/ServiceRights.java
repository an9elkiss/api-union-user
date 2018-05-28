package com.an9elkiss.api.user.constant;

public enum ServiceRights {
	MENU_HOME(1,"菜单权限", 1, "首页", 1, 0),
	MENU_TIME_DOMINATOR(1,"菜单权限", 101, "时间管理", 1, 0),
	MENU_TIME_ENTRIES(1,"菜单权限", 102, "日程记录", 2, 101),
	MENU_TIME_ENTRY_CHART(1, "菜单权限", 103, "日程报表", 2, 101),

	API_WEEK_DAYS(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRY_NEW(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRY_GET(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRY_UPDATE(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRY_DEL(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRIES_GET(2, "API权限", -1, null, -1, -1),
	API_TIME_ENTRIES_DAILY(2, "API权限", -1, null, -1, -1);
	
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
