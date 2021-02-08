package com.cloud.service;

import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Payment;
import org.springframework.stereotype.Component;

/**
 * 对feign接口的服务降级处理
 * @author Administrator
 * @create 2021-02-09 0:35
 */
@Component
public class nacospaymentimpl implements nacospaymentclient {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));

    }
}
