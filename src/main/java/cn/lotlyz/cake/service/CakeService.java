package cn.lotlyz.cake.service;



import cn.lotlyz.cake.model.Cake;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CakeService {

    /*
    * 查询所有蛋糕
    * @return
    **/
    List<Cake> findAll();

    /**
     * 批量查询
     *
     * @param ids
     */
    List<Cake> findByIds(Integer[] ids);

    /**
     * 新增蛋糕
     * @param cake
     */
    void add(Cake cake);

    /**
     * 通过id删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 批量删除
     * @param ids
     */
    void batchDel(Integer[] ids);

    /**
     * 修改蛋糕信息
     * @param cake
     */
    void updateCake(Cake cake);

    /**
     * 文件上传
     * @param file
     */
    void upload(MultipartFile file);
}
