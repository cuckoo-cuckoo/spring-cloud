package com.cloud.client;

import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Administrator
 * @create 2021-01-30 19:44
 */
@Component   //加入容器方便注入使用
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignClient {

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB();

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") long id);

}
