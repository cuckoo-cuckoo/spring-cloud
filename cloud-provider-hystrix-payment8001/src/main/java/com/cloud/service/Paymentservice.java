package com.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @create 2021-01-31 11:20
 */
@Service
public class Paymentservice {

    //成功
    public String paymentinfo(Integer id) {

        return  "线程池==="+Thread.currentThread().getName()+"==paymnetinfo==>id=="+id+"===哈哈哈哈";
    }

    //失败
    @HystrixCommand(fallbackMethod ="TimeOuthandle",commandProperties = {
            //设置3秒内响应就是正常的服务  execution.isolation.thread.timeoutInMilliseconds来自 HystrixCommandProperties
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id)  {
        int s=10/0;
        int timenumber=5;
        try {
            TimeUnit.SECONDS.sleep(timenumber);  //线程休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池===="+Thread.currentThread().getName()+"paymentInfo_TimeOut==>id"+id+"===呜呜呜";
    }

    //写一个服务降级的处理方法
     public String TimeOuthandle(Integer id){

         return "线程池："+Thread.currentThread().getName()+"   系统繁忙, 请稍候再试  ,id：  "+id+"\t"+"哭了哇呜";
     }


    //演示服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "10"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id <0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback( Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }


    //演示服务熔断
    @HystrixCommand(fallbackMethod = "paymentid",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "2"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "10"), //失败率达到多少后跳闸
    })
    public String payment(Integer id){
        if (id >32){
            throw new RuntimeException("*****id 不可以大于32");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }

    public String paymentid(Integer id){
        return "数值太大了=====》》》请稍候再试,(┬＿┬)/~~     id: " +id;
    }
}
