package com.cloud.controller;

import com.cloud.client.PaymentHystrixclient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 在controller中添加降级处理方法，代码耦合度较高，为每个方法添加一个不太好
 * 客户端80通过feign 调用8001服务端，出现超时等问题的根本原因是feign远程调用服务端这一部分，所以对feign进行降级处理
 * @author Administrator
 * @create 2021-01-31 12:41
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")  //指定默认的降级处理方法
public class OrderHystrixController {
    @Resource
    private PaymentHystrixclient paymentHystrixclient;



    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result =this.paymentHystrixclient.paymentinfo(id);
        log.info("*******result:"+result);
        return result;
    }
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//            //在1.5秒内得到反映就是正常
//    })
//    @HystrixCommand   //不指定服务降级的处理方法就使用默认的配置
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = this.paymentHystrixclient.paymentInfo_TimeOut(id);
        log.info("*******result:"+result);
        return result;
    }



//    //兜底方法
//    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
//        return "我是消费者80，服务器的支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
//    }
////下面是全局fallback方法
//    public String payment_Global_FallbackMethod(){
//        return "Global异常处理信息，请稍后再试,(┬＿┬)";
//    }
}
