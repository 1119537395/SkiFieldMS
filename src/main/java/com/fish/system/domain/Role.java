package com.fish.system.domain;

import java.io.Serializable;

/**
 * @ClassName Role
 * @Description 角色(role)实体类
 * @Author 柚子茶
 * @Date 2020/11/26 15:03
 * @Version 1.0
 */
public class Role implements Serializable {

	private static final long serialVersionUID = -6462899821405987182L;

	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private Integer available;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}
}
