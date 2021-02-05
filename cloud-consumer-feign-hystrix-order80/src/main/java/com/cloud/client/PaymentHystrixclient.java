package com.cloud.client;

import com.cloud.service.PaymentHystrixServiceClientimpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @create 2021-01-31 12:40
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = PaymentHystrixServiceClientimpl.class)
public interface PaymentHystrixclient {


    @RequestMapping("/payment/hystrix/ok/{id}")
    public String paymentinfo(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
