package com.fish.system.utils;

/**
 * @InterfaceName MessageConstant
 * @Description 通用常量的定义
 * @Author 柚子茶
 * @Date 2020/12/11 23:26
 * @Version 1.0
 */
public interface MessageConstant {


	/** 可用状态 */
	Integer AVAILABLE_TRUE = 1;
	Integer AVAILABLE_FALSE = 0;

	/**
	 * 用户类型
	 */
	Integer USER_TYPE_SUPER = 1;
	Integer USER_TYPE_NORMAL = 2;


	/**
	 * 操作状态
	 */
	String DATA_ADD_SUCCESS = "数据添加成功~";
	String DATA_ADD_FAILURE = "数据添加失败~";

	String UPDATE_DATA_SUCCESS = "数据更新成功~";
	String UPDATE_DATA_FAILURE = "数据更新失败~";

	String DELETE_DATA_SUCCESS = "数据删除成功~";
	String DELETE_DATA_FAILURE = "数据删除失败~";

	String ASSIGN_DATA_SUCCESS = "分配权限成功~";
	String ASSIGN_DATA_FAILURE = "分类权限失败，请重新尝试";

	String REGISTER_SUCCESS = "注册成功!";
	String REGISTER_FAILURE = "注册失败，请重新尝试";

	String UPLOAD_DATA_SUCCESS = "上传成功";
	String UPLOAD_DATA_FAILURE = "上传失败，请重新尝试!";

	String LOGIN_SUCCESS = "登录成功";
	String LOGIN_FAILURE = "账号或密码错误，请重新登录!";

	String FINISH_SUCCESS = "结算成功~";
	String FINISH_FAILURE = "结算失败，请重新尝试";

	String LOGIN_CAPTCHA_ERROR = "输入的验证码错误!";

	String BUY_TOURIST_SUCCESS = "购票成功";
	String BUY_TOURIST_FAILURE = "购票失败，请重新尝试!";

	Integer CODE_SUCCESS = 200;
	Integer CODE_ERROR = 404;

	/** 验证码的错误码值 */
	Integer CAPTCHA_SUCCESS = 203;
	Integer CAPTCHA_ERROR = 303;

	/** 登录的错误码值 */
	Integer LOGIN_CODE_SUCCESS = 100;
	Integer LOGIN_CODE_ERROR = 104;

	/**
	 * 常用String类型的数字常量
	 */
	String CODE_NUMBER_STRING_ONE = "1";
	String CODE_NUMBER_STRING_ZERO = "0";

	/**
	 * 常用Integer类型的数字常量
	 */
	Integer CODE_NUMBER_INTEGER_ONE = 1;
	Integer CODE_NUMBER_INTEGER_ZERO = 0;

	/**
	 * 用户默认密码
	 */
	String USER_DEFAULT_PASSWORD = "1";

	/**
	 * 临时文件后缀
	 */
	String FILE_UPLOAD_TEMP = "_temp";
	String ORDER_HEAD = "SK";

	/**
	 * 默认图片地址
	 */
	String IMG_DEFAULT_ADDRESS = "images/defaultPicture.jpg";
	String PICTURE__DEFAULT_ADDRESS = "images/default.png";


}
