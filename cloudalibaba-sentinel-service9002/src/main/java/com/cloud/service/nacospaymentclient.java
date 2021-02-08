package com.cloud.service;

import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Administrator
 * @create 2021-02-09 0:33
 */
@FeignClient(value = "nacos-payment-provider",fallback = nacospaymentimpl.class)
public interface nacospaymentclient {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
