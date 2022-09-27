package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.Order;
import cn.lotlyz.cake.model.User;
import cn.lotlyz.cake.service.UserService;
import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    public UserService userService;


//    @RequestMapping("findAll()")
//    public Map findAll(){
//        return userService.seeList();
//    }
    @RequestMapping("findByPage()")
    public Map findByPage(
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "limit",required = false,defaultValue = "3") Integer pageSize
    ){

        //System.out.println(pageNum);//当前页
        //System.out.println(pageSize);//每页显示条数

        //设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        //紧跟在PageHelper.startPage（）后才会被分页
        List<User> medicalList = userService.seeList();

        //创建PageInfo对象
        PageInfo<User> pageInfo = new PageInfo<>(medicalList);

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());//总记录数
        map.put("data",pageInfo.getList());//分页数据

        return map;
    }


    @RequestMapping("addUser()")
    @ResponseBody
    public void  addUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException{

        userService.addUser(user);

        response.sendRedirect(request.getContextPath() + "/home.html");

    }

    @RequestMapping ("cutOff()")
    public String  cutOff( int id ){
        userService.cutOff(id);
        return "success";
    }

    @RequestMapping("update()")
    @ResponseBody
    public void update(User user, HttpServletRequest request, HttpServletResponse response) throws IOException{
        userService.updateUser(user);

        response.sendRedirect(request.getContextPath() + "/home.html");
    }
    @RequestMapping("batchDel()")
    public  String batchDel(Integer [] userIds){
        System.out.println(userIds);
        userService.cutOffs(userIds);
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
//    //MultipartFile的参数名必须是：file
//    @RequestMapping("upload()")
//    public Map upload(MultipartFile file){
//        System.out.println(file);
//        HashMap<String, Object> map = new HashMap<>();
//        if(file!=null){
//            System.out.println(file.getOriginalFilename());//输出上传的文件名
//
//            //调用上传的方法
//            userService.upload(file);
//
//            map.put("code",0);
//            map.put("msg","success");
//        }
//        return map;
//    }


}
