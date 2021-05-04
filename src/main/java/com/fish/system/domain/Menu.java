package com.fish.system.domain;

import java.io.Serializable;

/**
 * @ClassName Menu
 * @Description 菜单树(menu)实体类
 * @Author 柚子茶
 * @Date 2020/11/26 14:55
 * @Version 1.0
 */
public class Menu implements Serializable {

	private static final long serialVersionUID = 6218729676364984780L;

	/**
	 * 菜单ID
	 */
	private Integer id;

	/**
	 * 父级菜单ID
	 */
	private Integer pid;

	/**
	 * 菜单名称
	 */
	private String title;

	/**
	 * 路由地址
	 */
	private String href;

	/**
	 * 是否展开
	 */
	private Integer spread;

	/**
	 * 目标
	 */
	private String target;

	/**
	 * 菜单图标
	 */
	private String icon;

	/**
	 * 是否可用
	 */
	private Integer available;

	public Menu() {}

	public Menu(Integer id, Integer pid, String title, String href, Integer spread, String target, String icon, Integer available) {
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.href = href;
		this.spread = spread;
		this.target = target;
		this.icon = icon;
		this.available = available;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	public Integer getSpread() {
		return spread;
	}

	public void setSpread(Integer spread) {
		this.spread = spread;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}


}
