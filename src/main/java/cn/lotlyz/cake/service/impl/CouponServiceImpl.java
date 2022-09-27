package cn.lotlyz.cake.service.impl;

import cn.lotlyz.cake.listener.CouponListener;
import cn.lotlyz.cake.mapper.CouponMapper;
import cn.lotlyz.cake.model.Coupon;
import cn.lotlyz.cake.service.CouponService;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: Lotlyz
 * @Date: 2022/9/23
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;
    
    @Override
    public List<Coupon> findAll() { return couponMapper.findAll();}

    @Override
    public void add(Coupon coupon) {
        couponMapper.add(coupon);
    }

    @Override
    public void deleteById(String id) {
        couponMapper.deleteById(id);
    }

    @Override
    public void updateCoupon(Coupon coupon) {
        couponMapper.updateCoupon(coupon);
    }

    @Override
    public void updateStatus(Coupon coupon) {
        couponMapper.updateStatus(coupon);
    }

    @Override
    public void batchDel(Integer[] ids) {
        couponMapper.batchDel(ids);
    }

    @Override
    public List<Coupon> findByIds(Integer[] ids) {
        return couponMapper.findByIds(ids);
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
        EasyExcel.read(inputStream, Coupon.class, new CouponListener(couponMapper)).sheet().doRead();
    }
}
