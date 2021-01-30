package com.cloud.controller;

import com.cloud.client.PaymentFeignClient;
import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @create 2021-01-30 19:43
 */
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignClient paymentFeignClient;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        return this.paymentFeignClient.get(id);
    }

}
