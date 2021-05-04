package com.fish.system.utils;

/**
 * @ClassName MessageEnum
 * @Description 定义通用的消息枚举
 * @Author 柚子茶
 * @Date 2020/11/26 19:15
 * @Version 1.0
 */
public enum MessageEnum {

	USER_LOGIN_ERROR_MSG(404,"账户名或密码错误"),
	USER_LOGIN_CODE_ERROR_MSG(404,"验证码输入错误"),

	ADD_DATA_SUCCESS(200,"数据添加成功~"),
	ADD_DATA_FAILURE(404,"数据添加失败~"),

	DATA_DELETE_SUCCESS(200,"数据删除成功~"),
	DATA_DELETE_FAILURE(404,"数据删除失败~"),

	DATA_MODIFY_SUCCESS(200,"数据修改成功~"),
	DATA_MODIFY_FAILURE(404,"数据修改失败~"),

	AVAILABLE_TYPE_TRUE(1,"可用菜单"),
	AVAILABLE_TYPE_FALSE(0,"不可用菜单"),

	USER_TYPE_SUPER(1,"系统管理员类型"),
	USER_TYPE_NORMAL(2,"普通用户类型");


	/*
	 *  提示信息
	 */
	private String message;

	/*
	 *  常用编码
	 */
	private Integer code;

	MessageEnum(Integer code,String message) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code)  {
		this.code = code;
	}
}
