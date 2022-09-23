package cn.lotlyz.cake.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: Lotlyz
 * @Date: 2022/9/23
 */
public class Coupon implements Serializable {


    /** 优惠券表ID */
    private Integer id;

    /** 优惠券名称 */
    private String name;

    /** 优惠券类型 */
    private String type;

    /** 兑换的优惠券面值 */
    private BigDecimal couponPrice;

    /** 最低消费多少金额可用优惠券 */
    private BigDecimal useMinPrice;

    /** 优惠券有效期限（单位：天） */
    private Integer couponTime;

    /** 状态（已发布，未发布） */
    private String status;

    /** 创建时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /** 结束时间 */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /** 可以使用该优惠券的蛋糕名称 */
    private String cakeName;

    /** 优惠券的数量*/
    private int amount;

    public Coupon() {
    }

    public Coupon(Integer id, String name, String type, BigDecimal couponPrice, BigDecimal useMinPrice, Integer couponTime, String status, Date createTime, Date endTime, String cakeName, int amount) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.couponPrice = couponPrice;
        this.useMinPrice = useMinPrice;
        this.couponTime = couponTime;
        this.status = status;
        this.createTime = createTime;
        this.endTime = endTime;
        this.cakeName = cakeName;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getUseMinPrice() {
        return useMinPrice;
    }

    public void setUseMinPrice(BigDecimal useMinPrice) {
        this.useMinPrice = useMinPrice;
    }

    public Integer getCouponTime() {
        return couponTime;
    }

    public void setCouponTime(Integer couponTime) {
        this.couponTime = couponTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", couponPrice=" + couponPrice +
                ", useMinPrice=" + useMinPrice +
                ", couponTime=" + couponTime +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", cake_name='" + cakeName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
