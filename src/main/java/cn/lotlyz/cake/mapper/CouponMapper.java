package cn.lotlyz.cake.mapper;

import cn.lotlyz.cake.model.Coupon;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: Lotlyz
 * @Date: 2022/9/23
 */

public interface CouponMapper {

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
     * 修改优惠券状态
     * @param coupon
     */
    void updateStatus(Coupon coupon);

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
     * 批量插入数据
     * @param cachedDataList
     */
    void save(List<Coupon> cachedDataList);

    /**
     * 文件上传
     * @param file
     */
    void upload(MultipartFile file);
}
