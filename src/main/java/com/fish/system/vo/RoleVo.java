package com.fish.system.vo;

import com.fish.system.domain.Role;

/**
 * @ClassName RoleVo
 * @Description 实体类(Role)属性拓展
 * @Author 柚子茶
 * @Date 2020/12/13 20:03
 * @Version 1.0
 */
public class RoleVo extends Role {

	/**
	 * 分页参数
	 */
	private Integer page;

	/**
	 * 分页参数
	 */
	private Integer limit;

	/**
	 * 用于接收多个id
	 */
	private Integer[] ids;


	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

}
