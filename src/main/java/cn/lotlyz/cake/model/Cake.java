package cn.lotlyz.cake.model;

import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;

public class Cake implements Serializable {

    /** 蛋糕表ID */
//    @ExcelProperty("蛋糕编号")//指定别名
    private Integer cakeId;

    /** 蛋糕名称 */
//    @ExcelProperty("蛋糕名称")
    private String cakeName;

    /** 蛋糕价格 */
//    @ExcelProperty("蛋糕价格")
    private int cakePrice;

    /** 蛋糕尺寸 */
//    @ExcelProperty("蛋糕尺寸")
    private int cakeSize;

    /** 蛋糕种类 */
//    @ExcelProperty("蛋糕种类")
    private String cakeType;

    public Cake() {
    }

    public Cake(Integer cakeId, String cakeName, int cakePrice, int cakeSize, String cakeType) {
        this.cakeId = cakeId;
        this.cakeName = cakeName;
        this.cakePrice = cakePrice;
        this.cakeSize = cakeSize;
        this.cakeType = cakeType;
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

    public int getCakePrice() {
        return cakePrice;
    }

    public void setCakePrice(int cakePrice) {
        this.cakePrice = cakePrice;
    }

    public int getCakeSize() {
        return cakeSize;
    }

    public void setCakeSize(int cakeSize) {
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
                ", cakePrice=" + cakePrice +
                ", cakeSize=" + cakeSize +
                ", cakeType='" + cakeType + '\'' +
                '}';
    }
}
