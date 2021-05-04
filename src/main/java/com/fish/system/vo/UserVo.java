package com.fish.system.vo;

import com.fish.system.domain.User;

/**
 * @ClassName UserVo
 * @Description
 * @Author 柚子茶
 * @Date 2020/11/26 15:18
 * @Version 1.0
 */
public class UserVo extends User {

	/**
	 * 分页参数
	 */
	private Integer page;

	/**
	 * 分页参数
	 */
	private Integer limit;

	/**
	 * 验证码
	 */
	private String code;

	/**
	 * 用于接收多个用户的id
	 * 实现批量删除
	 */
	private Integer[] userIds;

	/** 登录身份选择的标记 0：工作人员登录 1：普通游客登录 */
	private Integer mark;


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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer[] getUserIds() {
		return userIds;
	}

	public void setUserIds(Integer[] userIds) {
		this.userIds = userIds;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
}
