package com.cloud.service;

import com.cloud.dao.PayMentDao;
import com.cloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @create 2021-01-29 18:35
 */
@SuppressWarnings("ALL")
@Service
public class PaymentService {

    @Autowired
    private PayMentDao payMentDao;

    public int create(Payment payment){
        return  this.payMentDao.insertpayment(payment);
    }


    public List<Payment> selects(long id){
        return this.payMentDao.select(id);
    }
}
