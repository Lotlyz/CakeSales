package cn.lotlyz.cake.controller;

import cn.lotlyz.cake.model.Order;
import cn.lotlyz.cake.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","success");
        map.put("count",1000);
        map.put("data",orderList);

        return map;
    }
}
