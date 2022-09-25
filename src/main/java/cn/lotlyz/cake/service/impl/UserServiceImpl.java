package cn.lotlyz.cake.service.impl;

import cn.lotlyz.cake.mapper.UserMapper;
import cn.lotlyz.cake.model.User;
import cn.lotlyz.cake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;


    @Override
    public Map seeList() {
        List<User> UserList = userMapper.findAll();

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",1000);
        map.put("data",UserList);
        return map;
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void cutOff(int id) {
        userMapper.deleteByid(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public List<User> findByIds(Integer[] ids) {
        List<User> userList=new ArrayList<User>();
        for (int i=1;i<ids.length;i++){
            User user = userMapper.findById(ids[i]);
            userList.add(user);
        }
        System.out.println(userList);
        return userList;
    }


}
