package cn.lotlyz.cake.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private Integer orderId;
    private Integer userId;
    private Integer cakeId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderPtime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderStime;

    private Double orderPrice;

    private Integer orderCount;

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

    public Integer getCakeId() {
        return cakeId;
    }

    public void setCakeId(Integer cakeId) {
        this.cakeId = cakeId;
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

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", cakeId=" + cakeId +
                ", orderPtime=" + orderPtime +
                ", orderStime=" + orderStime +
                ", orderPrice=" + orderPrice +
                ", orderCount=" + orderCount +
                '}';
    }
}