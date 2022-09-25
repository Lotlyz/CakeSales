package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.User;
import cn.lotlyz.cake.service.UserService;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
        return "success";
    }

    @RequestMapping ("cutOff()")
    public String  cutOff( int id ){
        userService.cutOff(id);
        return "success";
    }
    @RequestMapping("update()")
    @ResponseBody
    public String update(User user){
        userService.updateUser(user);
        return "success";
    }
    @RequestMapping("wirteExcel()")
    public void wirteExcel(Integer [] ids, HttpServletResponse response) throws IOException {
        //System.out.println(Arrays.toString(ids));
        System.out.println("开始wirteExcel");
        if(ids.length > 0){
            List<User> userList = userService.findByIds(ids);
            System.out.println(userList);

            System.out.println("系统时间：" + System.currentTimeMillis() );

            String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            System.out.println(time);

            // 写法2
            //String fileName = "D:/patient-" + System.currentTimeMillis() + ".xlsx";
            //String fileName = "D:/patient-" + time + ".xlsx";
            // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
            // 如果这里想使用03 则 传入excelType参数即可
            //EasyExcel.write(fileName, Patient.class).sheet("患者列表").doWrite(patientList);

            //以下载的方式打开
            String fileName = "user-" + time + ".xlsx";
            response.setHeader("Content-Disposition", "attachment;filename="+fileName);
            //获取输出流
            ServletOutputStream outputStream = response.getOutputStream();
            //流的方式写入
            EasyExcel.write(outputStream, User.class).sheet("用户列表").doWrite(userList);
        }
    }


}
