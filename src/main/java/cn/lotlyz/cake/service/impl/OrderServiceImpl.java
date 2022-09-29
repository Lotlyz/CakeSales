package cn.lotlyz.cake.service.impl;

import cn.lotlyz.cake.listener.OrderListener;
import cn.lotlyz.cake.mapper.OrderMapper;
import cn.lotlyz.cake.model.Order;
import cn.lotlyz.cake.service.OrderService;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
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

    @Override
    public void upload(MultipartFile file) {

        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法3：
        //fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";

        InputStream inputStream = null;

        //获取输入流
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(inputStream, Order.class, new OrderListener(orderMapper)).sheet().doRead();

    }


}
