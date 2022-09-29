package cn.lotlyz.cake.service.impl;

import cn.lotlyz.cake.listener.CakeListener;
import cn.lotlyz.cake.listener.CouponListener;
import cn.lotlyz.cake.mapper.CakeMapper;
import cn.lotlyz.cake.model.Cake;
import cn.lotlyz.cake.model.Coupon;
import cn.lotlyz.cake.service.CakeService;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CakeServiceImpl implements CakeService {

    @Autowired
    private CakeMapper cakeMapper;

    @Override
    public List<Cake> findAll() {
        return cakeMapper.findAll();
    }

    @Override
    public List<Cake> findByIds(Integer[] ids) {
        return cakeMapper.findByIds(ids);
    }

    @Override
    public void add(Cake cake) {
        cakeMapper.add(cake);
    }

    @Override
    public void deleteById(String id) {
        cakeMapper.deleteById(id);
    }

    @Override
    public void batchDel(Integer[] ids) {
        cakeMapper.batchDel(ids);
    }

    @Override
    public void updateCake(Cake cake) {
        cakeMapper.updateCake(cake);
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
        EasyExcel.read(inputStream, Cake.class, new CakeListener(cakeMapper)).sheet().doRead();

    }
}
