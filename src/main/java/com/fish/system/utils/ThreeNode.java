package com.fish.system.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ThreeNode
 * @Description 将后台查询到的数据封装成树结构形式
 * @Author 柚子茶
 * @Date 2020/11/28 23:01
 * @Version 1.0
 */
public class ThreeNode {

	private Integer id;

	@JsonProperty("parentId")
	private Integer pid;

	private String title;

	private String icon;

	private String href;

	private Boolean spread;

	private String target;

	private List<ThreeNode> children = new ArrayList<>();

	/**
	 * 开启复选框树所需要的属性
	 * 默认不选中 0
	 * 选中 1
	 */
	private String checkArr = "0";

	public ThreeNode() {}

	/**
	 * @param id    菜单ID
	 * @param pid	菜单父级ID
	 * @param title 菜单名称
	 * @param icon  菜单图标
	 * @param href  菜单路由地址
	 * @param spread 是否展开
	 * @param target 是否在新页面打开
	 * @return null
	 * @description 导航菜单栏的格式封装
	 * @author 柚子茶
	 * @date 2020/11/28 23:05
	 **/
	public ThreeNode(Integer id, Integer pid, String title, String icon, String href, Boolean spread, String target) {
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.icon = icon;
		this.href = href;
		this.spread = spread;
		this.target = target;
	}

	public ThreeNode(Integer id, Integer pid, String title, Boolean spread, String checkArr) {
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.spread = spread;
		this.checkArr = checkArr;
	}



	public String getCheckArr() {
		return checkArr;
	}

	public void setCheckArr(String checkArr) {
		this.checkArr = checkArr;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<ThreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<ThreeNode> children) {
		this.children = children;
	}
}
