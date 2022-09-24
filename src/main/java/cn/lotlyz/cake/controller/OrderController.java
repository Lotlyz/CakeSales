package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.Order;
import cn.lotlyz.cake.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        System.out.println(orderList);
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



}
