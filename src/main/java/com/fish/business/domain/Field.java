package com.fish.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Field
 * @Description 滑雪场地实体类
 * @Author 柚子茶
 * @Date 2021/4/1 16:19
 * @Version 1.0
 */
public class Field implements Serializable {

    private static final long serialVersionUID = 6272769164071692992L;

    private Integer fieldId;

    private String fieldRoad;

    private String fieldGrade;

    private String fieldSession;

    private String fieldPeriod;

    private BigDecimal fieldPrice;

    private Integer fieldCapacity;

    private String fieldInfo;

    private Integer fieldState;

    private Integer ticketNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Integer createUserId;

    private String createUserName;

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldRoad() {
        return fieldRoad;
    }

    public void setFieldRoad(String fieldRoad) {
        this.fieldRoad = fieldRoad == null ? null : fieldRoad.trim();
    }

    public String getFieldGrade() {
        return fieldGrade;
    }

    public void setFieldGrade(String fieldGrade) {
        this.fieldGrade = fieldGrade == null ? null : fieldGrade.trim();
    }

    public String getFieldSession() {
        return fieldSession;
    }

    public void setFieldSession(String fieldSession) {
        this.fieldSession = fieldSession == null ? null : fieldSession.trim();
    }

    public String getFieldPeriod() {
        return fieldPeriod;
    }

    public void setFieldPeriod(String fieldPeriod) {
        this.fieldPeriod = fieldPeriod == null ? null : fieldPeriod.trim();
    }

    public BigDecimal getFieldPrice() {
        return fieldPrice;
    }

    public void setFieldPrice(BigDecimal fieldPrice) {
        this.fieldPrice = fieldPrice;
    }

    public Integer getFieldCapacity() {
        return fieldCapacity;
    }

    public void setFieldCapacity(Integer fieldCapacity) {
        this.fieldCapacity = fieldCapacity;
    }

    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo == null ? null : fieldInfo.trim();
    }

    public Integer getFieldState() {
        return fieldState;
    }

    public void setFieldState(Integer fieldState) {
        this.fieldState = fieldState;
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

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}