package cn.lotlyz.cake.mapper;

import cn.lotlyz.cake.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
 * 持久层（dao）：访问数据库
 */
@Repository
public interface OrderMapper {
   List<Order> findAll();

   void deleteById(String id);

   void batchDel(Integer[] ids);

   List<Order> findByIds(Integer[] ids);

   void add(Order order);

   void updateOrder(Order order);

   void findByUid(Integer id);

   void save(List<Order> cacheDataList);
}
