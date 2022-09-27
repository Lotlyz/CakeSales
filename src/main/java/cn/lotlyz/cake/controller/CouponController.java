package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.Coupon;
import cn.lotlyz.cake.service.CouponService;
import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

/**
 * @Author: Lotlyz
 * @Date: 2022/9/23
 */
@RestController
@RequestMapping("coupon")//一级访问路径
public class CouponController {

    @Autowired
    private CouponService couponService;

    @RequestMapping("findAll")
    public Map findAll(){
        List<Coupon> CouponList = couponService.findAll();

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",1000);
        map.put("data",CouponList);

        return map;
    }
    @RequestMapping("findByPage")
    public Map findByPage(
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "limit",required = false,defaultValue = "8") Integer pageSize
    ){

        //System.out.println(pageNum);//当前页
        //System.out.println(pageSize);//每页显示条数

        //设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        //紧跟在PageHelper.startPage（）后才会被分页
        List<Coupon> couponList = couponService.findAll();

        //创建PageInfo对象
        PageInfo<Coupon> pageInfo = new PageInfo<>(couponList);

        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());//总记录数
        map.put("data",pageInfo.getList());//分页数据

        return map;
    }
//    @RequestMapping("add1")
//    public void add1(Coupon coupon, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //System.out.println(patient);
//        couponService.add(coupon);
//
//        //添加完之后，跳转到首页
//        response.sendRedirect(request.getContextPath() + "/index.html");
//    }

    @RequestMapping("add")
    public String add(Coupon coupon,HttpServletRequest request, HttpServletResponse response) throws IOException {
        //System.out.println(patient);
        couponService.add(coupon);
        //添加完之后，跳转到首页
//        System.out.println("想看的路径"+request.getContextPath());
//        response.sendRedirect(request.getContextPath() + "index.html");

        return "success";
    }

    @RequestMapping("deleteById")
    public String deleteById(String id){
        //System.out.println(id);
        couponService.deleteById(id);
        return "success";
    }

    @RequestMapping("updateCoupon")
    public String updateCoupon(Coupon coupon){

        System.out.println(coupon);
        couponService.updateCoupon(coupon);

        return "success";
    }


     //修改优惠券的发布状态
    @RequestMapping("updateStatus")
    public String updateStatus(int id,String  status){
        Coupon coupon = new Coupon();
        coupon.setId(id);
        coupon.setStatus(status);
        couponService.updateStatus(coupon);
        return "success";
    }


    @RequestMapping("batchDel")
    public String batchDel(Integer [] ids){

        //System.out.println(Arrays.toString(ids));
        //判断
        if(ids.length > 0){
            couponService.batchDel(ids);
        }

        return "success";
    }

    @RequestMapping("wirteExcel")
    public void wirteExcel(Integer [] ids,HttpServletResponse response) throws IOException {
        //System.out.println(Arrays.toString(ids));

        if(ids.length > 0){
            List<Coupon> couponList = couponService.findByIds(ids);
            System.out.println(couponList);

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
            String fileName = "coupon-" + time + ".xlsx";
            response.setHeader("Content-Disposition", "attachment;filename="+fileName);
            //获取输出流
            ServletOutputStream outputStream = response.getOutputStream();
            //流的方式写入
            EasyExcel.write(outputStream, Coupon.class).sheet("优惠券列表").doWrite(couponList);
        }

    }

    //MultipartFile的参数名必须是：file
    @RequestMapping("upload")
    public Map upload(MultipartFile file){
        HashMap<String, Object> map = new HashMap<>();
        if(file!=null){
            System.out.println(file.getOriginalFilename());//输出上传的文件名
            //调用上传的方法
            couponService.upload(file);
            map.put("code",0);
            map.put("msg","success");
        }
        return map;
    }
}
