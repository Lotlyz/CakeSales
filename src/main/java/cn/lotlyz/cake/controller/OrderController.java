package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.Order;
import cn.lotlyz.cake.service.OrderService;
import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 表现层（web层）：接收前端传递的数据，返回数据给前端
 * @Controller，@RestController，@Service，@Repository创建对象所需的注解
 */

@RestController//返回json类型的数据
@RequestMapping("order")//一级访问路径
public class OrderController {

    @Autowired//自动装配，将spring容器中的PatientService类型对象，赋值给patientService
    private OrderService orderService;


    @RequestMapping("findAll")
    public Map findAll(){
        List<Order> orderList = orderService.findAll();
//        System.out.println(orderList.get(0));
        System.out.println(orderList);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",1000);
        map.put("data",orderList);
        return map;
    }

    @RequestMapping("findByPage")
    public Map findByPage(
            @RequestParam(value = "page",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "limit",required = false,defaultValue = "3") Integer pageSize
    ){
        PageHelper.startPage(pageNum,pageSize);
        //紧跟在PageHelper.startPage（）后才会被分页
        List<Order> orderList = orderService.findAll();

        //创建PageInfo对象
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());//总记录数
        map.put("data",pageInfo.getList());//分页数据

        return map;

    }

    @RequestMapping("deleteById")
    public String deleteById(String id){
        System.out.println("获取到了id为"+id);
        orderService.deleteById(id);
        return "success";
    }

    @RequestMapping("batchDel")

    public String batchDel(Integer[] ids){
        System.out.println("走到这里了");
        System.out.println(Arrays.toString(ids));//null值
        if(ids.length>0) {
            orderService.batchDel(ids);
        }
        return "success";
    }

    @RequestMapping("wirteExcel")
    public void wirteExcel(Integer [] ids, HttpServletResponse response) throws IOException {
        //System.out.println(Arrays.toString(ids));

        if(ids.length > 0){
            List<Order> orderList = orderService.findByIds(ids);
            System.out.println(orderList);
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
            String fileName = "order-" + time + ".xlsx";
            response.setHeader("Content-Disposition", "attachment;filename="+fileName);
            //获取输出流
            ServletOutputStream outputStream = response.getOutputStream();
            //流的方式写入
            EasyExcel.write(outputStream, Order.class).sheet("订单列表").doWrite(orderList);
        }

    }
    @RequestMapping("add")
    public void add(Order order, HttpServletRequest request, HttpServletResponse response)throws IOException{
        orderService.add(order);
        //添加完之后，跳转到首页
        System.out.println(request.getContextPath()+"-----");
        response.sendRedirect(request.getContextPath() + "/index.html");

    }


}

