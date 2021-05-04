package com.fish.system.utils;

/**
 * @ClassName CommonReturnType
 * @Description 通用的消息模板类
 * @Author 柚子茶
 * @Date 2020/11/26 19:42
 * @Version 1.0
 */
public class CommonReturnType {

	/**
	 * 状态码
	 */
	private Integer code;

	/**
	 * 提示信息
	 */
	private String msg;


	/** 响应的状态码  */
	public CommonReturnType(Integer code){
		this.code = code;
	}

	/** 响应的状态码和消息 */
	public CommonReturnType(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/** 添加成功 */
	public static final CommonReturnType ADD_SUCCESS =
			new CommonReturnType(
					MessageConstant.CODE_SUCCESS,
					MessageConstant.DATA_ADD_SUCCESS
			);

	/** 添加失败 */
	public static final CommonReturnType ADD_FAILURE =
			new CommonReturnType(
					MessageConstant.CODE_ERROR,
					MessageConstant.DATA_ADD_FAILURE
			);

	/** 删除成功 */
	public static final CommonReturnType DELETE_SUCCESS =
			new CommonReturnType(
					MessageConstant.CODE_SUCCESS,
					MessageConstant.DELETE_DATA_SUCCESS
			);

	/** 删除失败 */
	public static final CommonReturnType DELETE_FAILURE =
			new CommonReturnType(
					MessageConstant.CODE_ERROR,
					MessageConstant.DELETE_DATA_FAILURE
			);

	/** 修改成功 */
	public static final CommonReturnType MODIFY_SUCCESS =
			new CommonReturnType(
					MessageConstant.CODE_SUCCESS,
					MessageConstant.UPDATE_DATA_SUCCESS
			);

	/** 修改失败 */
	public static final CommonReturnType MODIFY_FAILURE =
			new CommonReturnType(
					MessageConstant.CODE_ERROR,
					MessageConstant.UPDATE_DATA_FAILURE
			);
	/** 上传成功 */
	public static final CommonReturnType UPLOAD_SUCCESS =
			new CommonReturnType(
					MessageConstant.CODE_SUCCESS,
					MessageConstant.UPLOAD_DATA_SUCCESS
			);

	/** 上传失败 */
	public static final CommonReturnType UPLOAD_FAILURE =
			new CommonReturnType(
					MessageConstant.CODE_ERROR,
					MessageConstant.UPLOAD_DATA_FAILURE
			);


	/** 验证码错误 */
	public static final CommonReturnType LOGIN_CAPTCHA_ERROR =
			new CommonReturnType(
					MessageConstant.CAPTCHA_ERROR,
					MessageConstant.LOGIN_CAPTCHA_ERROR
			);

	/** 账号或密码错误 */
	public static final CommonReturnType LOGIN_FAILURE =
			new CommonReturnType(
					MessageConstant.LOGIN_CODE_ERROR,
					MessageConstant.LOGIN_FAILURE
			);

	public static final CommonReturnType LOGIN_SUCCESS =
			new CommonReturnType(
					MessageConstant.LOGIN_CODE_SUCCESS,
					MessageConstant.LOGIN_SUCCESS
			);

	public static final CommonReturnType REGISTER_SUCCESS =
			new CommonReturnType(
					MessageConstant.CODE_SUCCESS,
					MessageConstant.REGISTER_SUCCESS
			);

	public static final CommonReturnType REGISTER_FAILURE =
			new CommonReturnType(
					MessageConstant.CODE_ERROR,
					MessageConstant.REGISTER_FAILURE
			);

	/** 结算成功 */
	public static final CommonReturnType FINISH_SUCCESS =
			new CommonReturnType(
					MessageConstant.CODE_SUCCESS,
					MessageConstant.FINISH_SUCCESS
			);

	/** 结算失败 */
	public static final CommonReturnType FINISH_FAILURE =
			new CommonReturnType(
					MessageConstant.CODE_ERROR,
					MessageConstant.FINISH_FAILURE
			);


	/** 分配成功 */
	public static final CommonReturnType ASSIGN_SUCCESS =
			new CommonReturnType(
					MessageConstant.CODE_SUCCESS,
					MessageConstant.ASSIGN_DATA_SUCCESS
			);

	/** 分配失败 */
	public static final CommonReturnType ASSIGN_FAILURE =
			new CommonReturnType(
					MessageConstant.CODE_SUCCESS,
					MessageConstant.ASSIGN_DATA_FAILURE
			);


	/** 成功状态码 */
	public static final CommonReturnType CODE_SUCCESS =
			new CommonReturnType(
				MessageConstant.CODE_SUCCESS
			);

	/** 失败状态码 */
	public static final CommonReturnType CODE_FAILURE =
			new CommonReturnType(
					MessageConstant.CODE_ERROR
			);

	public static final CommonReturnType BUY_SUCCESS =
			new CommonReturnType(
					MessageConstant.CODE_SUCCESS,
					MessageConstant.BUY_TOURIST_SUCCESS
			);
	public static final CommonReturnType BUY_FAILURE =
			new CommonReturnType(
					MessageConstant.CODE_ERROR,
					MessageConstant.BUY_TOURIST_FAILURE
			);

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
