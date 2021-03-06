package com.cloud.springcloud.controller;

import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Administrator
 * @create 2021-01-29 18:40
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    private static  final Logger LOGGER= LoggerFactory.getLogger(PaymentController.class);
    @PostMapping("/create")
    public CommonResult<Payment> create(Payment payment){
        int i = this.paymentService.create(payment);
        LOGGER.info("插入数据{}条",i);
    if(i>0){
        LOGGER.info("当前调用端口=====》{}",port);
        return new CommonResult<>(201,"插入数据库成功");

    }
        return new CommonResult<>(500,"插入数据库失败");
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id){
        List<Payment> select = this.paymentService.selects(id);
        if(CollectionUtils.isEmpty(select)){
            return new CommonResult<Payment>(400,"找不到");

        }
        LOGGER.info("当前调用端口=====》{}",port);
        return new CommonResult<>(201,"数据查找成功");
    }
    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return port;
    }
}
