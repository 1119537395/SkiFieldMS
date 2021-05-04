package com.fish.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Tourist
 * @Description 游客实体类
 * @Author 柚子茶
 * @Date 2021/4/1 11:59
 * @Version 1.0
 */
public class Tourist implements Serializable {

    private static final long serialVersionUID = -4497149893225610337L;

    private Integer touristId;

    private String touristName;

    private Integer touristSex;

    private String touristPhone;

    private String touristLoginAccount;

    private String touristLoginPassword;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Integer createUserId;

    private String createUserName;

    public Integer getTouristId() {
        return touristId;
    }

    public void setTouristId(Integer touristId) {
        this.touristId = touristId;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName == null ? null : touristName.trim();
    }

    public Integer getTouristSex() {
        return touristSex;
    }

    public void setTouristSex(Integer touristSex) {
        this.touristSex = touristSex;
    }

    public String getTouristPhone() {
        return touristPhone;
    }

    public void setTouristPhone(String touristPhone) {
        this.touristPhone = touristPhone == null ? null : touristPhone.trim();
    }

    public String getTouristLoginAccount() {
        return touristLoginAccount;
    }

    public void setTouristLoginAccount(String touristLoginAccount) {
        this.touristLoginAccount = touristLoginAccount == null ? null : touristLoginAccount.trim();
    }

    public String getTouristLoginPassword() {
        return touristLoginPassword;
    }

    public void setTouristLoginPassword(String touristLoginPassword) {
        this.touristLoginPassword = touristLoginPassword == null ? null : touristLoginPassword.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "touristId=" + touristId +
                ", touristName='" + touristName + '\'' +
                ", touristSex=" + touristSex +
                ", touristPhone='" + touristPhone + '\'' +
                ", touristLoginAccount='" + touristLoginAccount + '\'' +
                ", touristLoginPassword='" + touristLoginPassword + '\'' +
                ", createTime=" + createTime +
                ", createUserId=" + createUserId +
                ", createUserName='" + createUserName + '\'' +
                '}';
    }
}