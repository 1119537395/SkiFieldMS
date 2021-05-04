package com.fish.business.vo;

import com.fish.business.domain.Order;

/**
 * @ClassName OrderVo
 * @Description
 * @Author 柚子茶
 * @Date 2021/4/4 12:42
 * @Version 1.0
 */
public class OrderVo extends Order {
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
