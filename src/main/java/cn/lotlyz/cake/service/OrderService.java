package cn.lotlyz.cake.service;

import cn.lotlyz.cake.model.Order;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    void deleteById(String id);

    void batchDel(Integer[] ids);


    List<Order> findByIds(Integer[] ids);


    void add(Order order);


  void updateOrder(Order order);


  void findByUid(Integer id);


  void upload(MultipartFile file);

}
