package cn.lotlyz.cake.model;

import lombok.Data;

@Data
public class Admin {
    public int id;
    public String name;
    public String password;
    public String captcha;
}
