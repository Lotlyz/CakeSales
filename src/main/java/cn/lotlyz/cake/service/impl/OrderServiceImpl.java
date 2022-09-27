package cn.lotlyz.cake.service.impl;

import cn.lotlyz.cake.mapper.OrderMapper;
import cn.lotlyz.cake.model.Order;
import cn.lotlyz.cake.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务逻辑层（service）：处理业务，做一些判断等等...
 */
@Service//PatientService ps = new PatientServiceImpl(); -> ps对象已经放到spring容器中
public class OrderServiceImpl  implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> findAll() {return orderMapper.findAll();}

    @Override
    public void deleteById(String id) {
        orderMapper.deleteById(id);
    }

    @Override
    public void batchDel(Integer[] ids) {orderMapper.batchDel(ids);}


    @Override
    public List<Order> findByIds(Integer[] ids) {
        return orderMapper.findByIds(ids);
    }

    @Override
    public void add(Order order) {
     orderMapper.add(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }

    @Override
    public void findByUid(Integer id) {
        orderMapper.findByUid(id);
    }


}
