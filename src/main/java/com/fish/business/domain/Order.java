package com.fish.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName Order
 * @Description 订单实体类
 * @Author 柚子茶
 * @Date 2021/4/3 11:59
 * @Version 1.0
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -1333184651353490248L;

    private String orderId;

    private Integer touristId;

    private Integer fieldId;

    private Integer buyTicketNumber;

    private BigDecimal paymentAmount;

    private String orderInfo;

    private Integer orderState;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Integer createUserId;

    /** 游客手机号 */
    private String touristPhone;

    /** 游客姓名 */
    private String touristName;

    /** 雪道名称 */
    private String fieldRoad;

    /** 门票价格 */
    private BigDecimal fieldPrice;

    /** 创建人 */
    private String createUserName;

    /** 记录订单的最初购买的票量 */
    private Integer oldBuyTicketNumber;

    /** 记录订单修改后购买的票量 */
    private Integer newBuyTicketNumber;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getTouristId() {
        return touristId;
    }

    public void setTouristId(Integer touristId) {
        this.touristId = touristId;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getBuyTicketNumber() {
        return buyTicketNumber;
    }

    public void setBuyTicketNumber(Integer buyTicketNumber) {
        this.buyTicketNumber = buyTicketNumber;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
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

    public String getTouristPhone() {
        return touristPhone;
    }

    public void setTouristPhone(String touristPhone) {
        this.touristPhone = touristPhone;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public String getFieldRoad() {
        return fieldRoad;
    }

    public void setFieldRoad(String fieldRoad) {
        this.fieldRoad = fieldRoad;
    }

    public BigDecimal getFieldPrice() {
        return fieldPrice;
    }

    public void setFieldPrice(BigDecimal fieldPrice) {
        this.fieldPrice = fieldPrice;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Integer getOldBuyTicketNumber() {
        return oldBuyTicketNumber;
    }

    public void setOldBuyTicketNumber(Integer oldBuyTicketNumber) {
        this.oldBuyTicketNumber = oldBuyTicketNumber;
    }

    public Integer getNewBuyTicketNumber() {
        return newBuyTicketNumber;
    }

    public void setNewBuyTicketNumber(Integer newBuyTicketNumber) {
        this.newBuyTicketNumber = newBuyTicketNumber;
    }
}