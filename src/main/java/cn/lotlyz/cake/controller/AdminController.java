package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.Admin;
import cn.lotlyz.cake.service.AdminService;
import cn.lotlyz.cake.utils.KaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    public AdminService adminService;

    static public String captcha;
    @RequestMapping("/login")
    public void login(Admin admin, HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException{
        System.out.println(captcha);
        System.out.println(admin.getCaptcha());



        boolean p  = adminService.login(admin);
        if (p ==true){
            if(admin.getCaptcha().equals(captcha)){
                response.sendRedirect(request.getContextPath() + "/home.html");
                session.setAttribute("admin",admin);
                System.out.println(admin);
            }else {
                response.sendRedirect(request.getContextPath() + "/index.html");
            }

        }else {
            response.sendRedirect(request.getContextPath() + "/index.html");
        }

    }
    @RequestMapping("createCaptcha")
    public void createCaptcha(HttpSession httpSession, HttpServletResponse response) throws IOException {

        //使用工具类返回验证码
        KaptchaUtil.createKaptchaImg(httpSession,response);
        captcha=httpSession.getAttribute("code").toString();
        System.out.println("验证码：" + captcha);

    }
}
