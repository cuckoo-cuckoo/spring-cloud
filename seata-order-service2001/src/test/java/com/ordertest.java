package com;

import com.dao.OrderDao;
import com.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @create 2021-02-07 20:30
 */
@SpringBootTest(classes = SeataOrder2001.class)
@RunWith(SpringRunner.class)
public class ordertest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void test1(){

        Order order = new Order();
        order.setCount(123);
        order.setMoney(BigDecimal.valueOf(1000l));
        order.setProductId(1233l);
        order.setStatus(0);
        orderDao.create(order);
    }

    @Test
    public void test2(){

        orderDao.updateorder(111l,1);

    }
}
