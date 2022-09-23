package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.User;
import cn.lotlyz.cake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    public UserService userService;


    @RequestMapping("findAll()")
    public Map findAll(){
        return userService.seeList();
    }


    @RequestMapping("addUser()")
    @ResponseBody
    public String  addUser(User user){
        userService.addUser(user);
        return "添加成功";
    }

    @RequestMapping ("cutOff()")
    public String  cutOff( int id ){
        userService.cutOff(id);
        return "删除成功";
    }
    @RequestMapping("update()")
    @ResponseBody
    public String update(User user){
        userService.updateUser(user);
        return "userList";
    }

}
