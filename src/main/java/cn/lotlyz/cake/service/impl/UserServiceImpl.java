package cn.lotlyz.cake.service.impl;

//import cn.lotlyz.cake.listener.UserListener;
import cn.lotlyz.cake.mapper.UserMapper;
import cn.lotlyz.cake.model.User;
import cn.lotlyz.cake.service.UserService;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserMapper userMapper;


    @Override
    public List<User> seeList() {
        List<User> UserList = userMapper.findAll();


        return UserList;
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
        for (int i=0;i<ids.length;i++){
            User user = userMapper.findById(ids[i]);
            userList.add(user);
        }
        System.out.println(userList);
        return userList;
    }

    @Override
    public void cutOffs(Integer[] userIds) {
        for (int i=0;i<userIds.length;i++){
           userMapper.deleteByid(userIds[i]);
        }
    }

//    @Override
//    public void upload(MultipartFile file) {
//        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
//        // 写法3：
//        //fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        InputStream inputStream = null;
//        //获取输入流
//        try {
//            inputStream = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(inputStream, User.class, new UserListener(userMapper)).sheet().doRead();
//    }


}
