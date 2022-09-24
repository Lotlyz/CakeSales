package cn.lotlyz.cake.service;

import cn.lotlyz.cake.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    void deleteById(String id);

    void batchDel(Integer[] ids);
}
