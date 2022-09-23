package cn.lotlyz.cake.model;

import javax.xml.crypto.Data;


public class User {
    public int uid;
    public String uName;
    public String uPassword;
    public String uIdCard;
    public Data uRegistrationTime;
    public String uAddress;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuIdCard() {
        return uIdCard;
    }

    public void setuIdCard(String uIdCard) {
        this.uIdCard = uIdCard;
    }

    public Data getuRegistrationTime() {
        return uRegistrationTime;
    }

    public void setuRegistrationTime(Data uRegistrationTime) {
        this.uRegistrationTime = uRegistrationTime;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uIdCard='" + uIdCard + '\'' +
                ", uRegistrationTime=" + uRegistrationTime +
                ", uAddress='" + uAddress + '\'' +
                '}';
    }

}
