package com.cloud.service;

import com.cloud.client.PaymentHystrixclient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**创建一个类实现feign 接口  为实现的方法进行降级处理
 * @author Administrator
 * @create 2021-01-31 16:54
 */
@Component
public class PaymentHystrixServiceClientimpl implements PaymentHystrixclient {

    @Override

    public String paymentinfo(Integer id) {
        return "我是消费者80，服务器的支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "Global异常处理信息，请稍后再试,(┬＿┬)";
    }
}
