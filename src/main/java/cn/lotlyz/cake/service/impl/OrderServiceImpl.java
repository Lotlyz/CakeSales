package cn.lotlyz.cake.service.impl;

import cn.lotlyz.cake.mapper.OrderMapper;
import cn.lotlyz.cake.model.Order;
import cn.lotlyz.cake.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * .             ____________________________________________________
 * .            /                                                    \
 * .           |    _____________________________________________     |
 * .           |   |                                             |    |
 * .           |   |  Though the road ahead is dangerous and     |    |
 * .           |   |  difficult, we can only achieve our goals   |    |
 * .           |   |  with constant efforts. We must press ahead |    |
 * .           |   |  with a sense of perseverance to expect a   |    |
 * .           |   |  better future.                             |    |
 * .           |   |                                             |    |
 * .           |   |                                             |    |
 * .           |   |                                             |    |
 * .           |   |                                             |    |
 * .           |   |                                             |    |
 * .           |   |                  @Author: 李云龙说你的13特别香 |    |
 * .           |   |                            @Date: 2022/9/23 |    |
 * .           |   |_____________________________________________|    |
 * .           |                                                      |
 * .            \_____________________________________________________/
 * .                   \_______________________________________/
 * .                _______________________________________________
 * .             _-'    .-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.  --- `-_
 * .          _-'.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.--.  .-.-.`-_
 * .       _-'.-.-.-. .---.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-`__`. .-.-.-.`-_
 * .    _-'.-.-.-.-. .-----.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-----. .-.-.-.-.`-_
 * . _-'.-.-.-.-.-. .---.-. .-----------------------------. .-.---. .---.-.-.-.`-_
 * .:-----------------------------------------------------------------------------:
 * .`---._.-----------------------------------------------------------------._.---'
 */
/**
 * 业务逻辑层（service）：处理业务，做一些判断等等...
 */
@Service//PatientService ps = new PatientServiceImpl(); -> ps对象已经放到spring容器中
public class OrderServiceImpl  implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> findAll() {return orderMapper.findAll();}

}
