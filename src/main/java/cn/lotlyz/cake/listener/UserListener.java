//package cn.lotlyz.cake.listener;
//
//import cn.lotlyz.cake.mapper.UserMapper;
//import cn.lotlyz.cake.model.User;
//import com.alibaba.excel.context.AnalysisContext;
//import com.alibaba.excel.read.listener.ReadListener;
//import com.alibaba.excel.util.ListUtils;
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//@Slf4j
//public class UserListener  implements ReadListener<User> {
//
//    private static final int BATCH_COUNT = 100;
//    /**
//     * 缓存的数据
//     */
//    private List<User> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
//    @Autowired
//    private UserMapper userMapper;
//
//    public UserListener(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
//
//    @Override
//    public void invoke(User user, AnalysisContext analysisContext) {
//        log.info("解析到一条数据:{}", JSON.toJSONString(user));
//        cachedDataList.add(user);
//        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
//        if (cachedDataList.size() >= BATCH_COUNT) {
//            saveData();
//            // 存储完成清理 list
//            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
//        }
//
//    }
//
//
//    @Override
//    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
//        saveData();
//        log.info("所有数据解析完成！");
//    }
//    /**
//     * 加上存储数据库
//     */
//    private void saveData() {
//        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
//        userMapper.save(cachedDataList);
//        log.info("存储数据库成功！");
//    }
//
//}
