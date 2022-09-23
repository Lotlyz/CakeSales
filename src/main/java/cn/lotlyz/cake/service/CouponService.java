package cn.lotlyz.cake.service;

import cn.lotlyz.cake.model.Coupon;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: Lotlyz
 * @Date: 2022/9/23
 */
public interface CouponService {

    /**
     * 查询所有优惠券
     * @return
     */
    List<Coupon> findAll();

    /**
     * 新增优惠券
     * @param coupon
     */
    void add(Coupon coupon);

    /**
     * 通过id删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 修改优惠券
     * @param coupon
     */
    void updateCoupon(Coupon coupon);

    /**
     * 批量删除
     * @param ids
     */
    void batchDel(Integer[] ids);

    /**
     * 批量查询
     *
     * @param ids
     */
    List<Coupon> findByIds(Integer[] ids);

    /**
     * 文件上传
     * @param file
     */
    void upload(MultipartFile file);
}
