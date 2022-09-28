package cn.lotlyz.cake.model;

import java.io.Serializable;

public class Cake implements Serializable {

    /** 蛋糕表ID */
    private Integer cakeId;

    /** 蛋糕名称 */
    private String cakeName;

    /** 蛋糕价格 */
    private String cakePrice;

    /** 蛋糕尺寸 */
    private String cakeSize;

    /** 蛋糕种类 */
    private String cakeType;

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

    public String getCakePrice() {
        return cakePrice;
    }

    public void setCakePrice(String cakePrice) {
        this.cakePrice = cakePrice;
    }

    public String getCakeSize() {
        return cakeSize;
    }

    public void setCakeSize(String cakeSize) {
        this.cakeSize = cakeSize;
    }

    public String getCakeType() {
        return cakeType;
    }

    public void setCakeType(String cakeType) {
        this.cakeType = cakeType;
    }

    @Override
    public String toString() {
        return "Cake{" +
                "cakeId=" + cakeId +
                ", cakeName='" + cakeName + '\'' +
                ", cakePrice='" + cakePrice + '\'' +
                ", cakeSize='" + cakeSize + '\'' +
                ", cakeType='" + cakeType + '\'' +
                '}';
    }
}
