package cn.lotlyz.cake.service;

import cn.lotlyz.cake.model.Admin;
import org.springframework.stereotype.Service;


public interface AdminService {
    Boolean login(Admin admin);
}
