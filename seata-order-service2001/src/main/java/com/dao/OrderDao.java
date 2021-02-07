package com.dao;

import com.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author Administrator
 * @create 2021-02-07 20:15
 */
@Mapper
public interface OrderDao {

    //新建订单
    public void create(Order order);

     //修改订单状态
    public void updateorder(@Param("userId") Long userId, @Param("status") Integer status);
}
