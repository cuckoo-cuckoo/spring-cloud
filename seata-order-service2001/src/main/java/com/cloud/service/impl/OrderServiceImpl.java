package com.cloud.service.impl;

import com.cloud.dao.OrderDao;
import com.cloud.inte.AccountService;
import com.cloud.inte.StorageService;
import com.cloud.pojo.Order;
import com.cloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @create 2021-02-07 21:02
 */
@Service
@Slf4j
public class OrderServiceImpl  implements OrderService {

    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Resource
    private OrderDao orderDao;
    @Override
    @GlobalTransactional(name="fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----->开始新建订单");
        //新建订单
        orderDao.create(order);
//        int a=10/0;
        //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");
        //扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");
        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.updateorder(order.getUserId(),0);
        log.info("----->修改订单状态结束");
        log.info("----->下订单结束了");
    }
}
