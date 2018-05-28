package com.an9elkiss.api.user.command;

import java.util.ArrayList;
import java.util.List;


public class MenusCmd {

	private List<MenuCmd> menus;

	public MenusCmd() {
		menus = new ArrayList<MenuCmd>();
	}

	public List<MenuCmd> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuCmd> menus) {
		this.menus = menus;
	}

}
