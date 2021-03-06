package com.beyond233.alibaba.service;

import com.beyond233.alibaba.pojo.Order;
import com.beyond233.alibaba.mapper.OrderMapper;
import com.beyond233.alibaba.rpc.AccountRpc;
import com.beyond233.alibaba.rpc.StorageRpc;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/8 19:42
 */
@Service
@Slf4j(topic = "订单服务")
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountRpc accountRpc;

    @Autowired
    private StorageRpc storageRpc;

    /**
     * 创建订单 并开启分布式事务管理
     * */
    @GlobalTransactional(name = "创建订单Service",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("---->创建订单:开始");
        orderMapper.create(order);

        log.info("---->扣减库存:开始");
        storageRpc.decrease(order.getCommodityCode(), order.getCount());
        log.info("---->扣减库存:结束");

        log.info("---->扣减余额:开始");
        accountRpc.decrease(order.getUserId(), order.getMoney());
        log.info("---->扣减余额:结束");

        log.info("---->状态更新:开始");
        orderMapper.updateOrder(order.getId(),1);
        log.info("---->状态更新:结束");

        log.info("---->创建订单:结束");
    }
}
