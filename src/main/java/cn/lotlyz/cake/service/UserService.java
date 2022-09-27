package cn.lotlyz.cake.service;

import cn.lotlyz.cake.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    List<User> seeList();
    void addUser(User user);
    void cutOff(int id);
    void updateUser(User user);
    List<User> findByIds(Integer[] ids);
    void cutOffs(Integer[] userIds);
//    void upload(MultipartFile file);
}

