package com.fish.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description 用户(user)实体类
 * @Author 柚子茶
 * @Date 2020/11/26 15:07
 * @Version 1.0
 */
public class User implements Serializable {

	private static final long serialVersionUID = 5321992841184396183L;

	private Integer userId;

	/** 员工工号 */
	private String userNumber;

	private Integer userSex;

	private String userName;

	private String userPhone;

	private String userAccount;

	private String userPassword;

	private Integer userType;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userNumber='" + userNumber + '\'' +
				", userSex=" + userSex +
				", userName='" + userName + '\'' +
				", userPhone='" + userPhone + '\'' +
				", userAccount='" + userAccount + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userType=" + userType +
				", createTime=" + createTime +
				'}';
	}
}
