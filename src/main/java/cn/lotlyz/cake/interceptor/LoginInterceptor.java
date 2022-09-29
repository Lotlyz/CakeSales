package cn.lotlyz.cake.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

public class LoginInterceptor implements HandlerInterceptor {

    //白名单
    private HashSet<String> whiteUrls = new HashSet<>();

    public LoginInterceptor(){
        whiteUrls.add("index.html");
        //whiteUrls.add("/captchaController/createCaptcha");//视拦截情况而定
        //whiteUrls.add("/admin/login");
    }

    //preHandle访问Controller方法前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("preHandle");

        //获取请求路径
        String requestURI = request.getRequestURI();//  /login.html
        String requestURL = request.getRequestURL().toString();//  http://localhost:8080/login.html

        //遍历
        for (String url : whiteUrls){
            //判断
            if(requestURI.contains(url)){
                return true;
            }
        }

        //判断当前是否登录过了
        if(request.getSession().getAttribute("admin")!=null){
            return true;
        }else{
            //未登录
            response.sendRedirect(request.getContextPath()+"/index.html");
            return false;
        }

    }

    //preHandle访问Controller方法后执行
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle");
//    }

    //最后执行
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion");
//    }
}
