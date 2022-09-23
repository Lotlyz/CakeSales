package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.User;
import cn.lotlyz.cake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void  addUser( User user){
        userService.addUser(user);
    }

}
