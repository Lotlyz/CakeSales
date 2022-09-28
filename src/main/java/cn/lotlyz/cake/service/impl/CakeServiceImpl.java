package cn.lotlyz.cake.service.impl;

import cn.lotlyz.cake.mapper.CakeMapper;
import cn.lotlyz.cake.model.Cake;
import cn.lotlyz.cake.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    }
}
