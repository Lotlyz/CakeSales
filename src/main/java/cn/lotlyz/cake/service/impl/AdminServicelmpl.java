package cn.lotlyz.cake.service.impl;

import cn.lotlyz.cake.mapper.AdminMapper;
import cn.lotlyz.cake.model.Admin;
import cn.lotlyz.cake.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicelmpl implements AdminService {
    @Autowired
     public   AdminMapper adminMapper;
    @Override
    public Boolean login(Admin admin) {
        String passwrod = adminMapper.selectpassword(admin.getName());
        if (passwrod == null) {
            return false;
        } else  {
            if (passwrod.equals(admin.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
}
