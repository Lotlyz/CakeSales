package cn.lotlyz.cake.service;

import cn.lotlyz.cake.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    Map seeList();
    void addUser(User user);
    void cutOff(int id);
    void updateUser(User user);
}

