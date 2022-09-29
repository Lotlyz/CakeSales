package cn.lotlyz.cake.listener;


import cn.lotlyz.cake.mapper.OrderMapper;
import cn.lotlyz.cake.model.Order;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Slf4j
public class OrderListener  implements ReadListener<Order> {
int i =0;

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */

    private static final int BATCH_COUNT = 100;


    /**
     * 缓存的数据
     */
    private List<Order> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    //private DemoDAO demoDAO;

    //public PatientListener() {
    // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
    //demoDAO = new DemoDAO();
    //}



    @Autowired
    private  OrderMapper orderMapper;
    /**
     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
     *
     * @param orderMapper
     */
    public OrderListener(OrderMapper orderMapper) {this.orderMapper=orderMapper;}

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(Order data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSON.toJSONString(data));

        cachedDataList.add(data);
      System.out.println("数据："+cachedDataList.get(i));
      i++;
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }
    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
        log.info("所有数据解析完成！");
    }

    private void saveData() {
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        orderMapper.save(cachedDataList);
        log.info("存储数据库成功！");
    }
}