package com.nssoft.model;

import java.util.List;

/**   
 *
 * @ClassName Menu
 * @Description 
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年12月15日 下午8:30:51    
 * @version V1.0      
 *    
 */
public class Menu {
	private String menu_id = null;
	private String title = null;
	private String href = null;
	private String exp = null;
	private List<Menu> subMenu = null;
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public List<Menu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}
	public Menu(){
		
	}
	public Menu(String menu_id, String title, String href, String exp,
			List<Menu> subMenu) {
		this.menu_id = menu_id;
		this.title = title;
		this.href = href;
		this.exp = exp;
		this.subMenu = subMenu;
	}
	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", title=" + title + ", href="
				+ href + ", exp=" + exp + ", subMenu=" + subMenu + "]";
	}
	
	
	
	
	
	
	
	
	
}
