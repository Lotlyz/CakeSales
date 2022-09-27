package cn.lotlyz.cake.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private Integer orderId;
    private Integer userId;
    private String userName;
    private Integer cakeId;
    private String cakeName;

    private Double cakePrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderPtime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderStime;
    private Integer orderCount;
    private Double orderPrice;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCakeId() {
        return cakeId;
    }

    public void setCakeId(Integer cakeId) {
        this.cakeId = cakeId;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public Double getCakePrice() {
        return cakePrice;
    }

    public void setCakePrice(Double cakePrice) {
        this.cakePrice = cakePrice;
    }

    public Date getOrderPtime() {
        return orderPtime;
    }

    public void setOrderPtime(Date orderPtime) {
        this.orderPtime = orderPtime;
    }

    public Date getOrderStime() {
        return orderStime;
    }

    public void setOrderStime(Date orderStime) {
        this.orderStime = orderStime;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", cakeId=" + cakeId +
                ", cakeName='" + cakeName + '\'' +
                ", cakePrice=" + cakePrice +
                ", orderPtime=" + orderPtime +
                ", orderStime=" + orderStime +
                ", orderCount=" + orderCount +
                ", orderPrice=" + orderPrice +
                '}';
    }
}