package com.cloud.dao;

import com.cloud.pojo.Payment;

import java.util.List;

/**
 * @author Administrator
 * @create 2021-01-29 18:02
 */
//@Mapper
public interface PayMentDao {

     public int insertpayment(Payment payment);

     public List<Payment> select(long id);
}
