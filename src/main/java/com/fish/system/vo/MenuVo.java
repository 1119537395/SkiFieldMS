package com.fish.system.vo;

import com.fish.system.domain.Menu;

/**
 * @ClassName MenuVo
 * @Description 实体类(menu)的属性扩展
 * @Author 柚子茶
 * @Date 2020/11/26 15:16
 * @Version 1.0
 */
public class MenuVo extends Menu {

	/**
	 * 分页参数
	 */
	private Integer page;

	/**
	 * 分页参数
	 */
	private Integer limit;

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
}
