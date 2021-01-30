package com.cloud.controller;

import com.cloud.pojo.CommonResult;
import com.cloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @create 2021-01-29 21:19
 */
@RestController
public class OrderController {

    private static  final  String prfex="http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/something")
    public CommonResult<Payment> findsomething(Payment payment){

          return restTemplate.postForObject(prfex+"/paymnet/create",payment, CommonResult.class);


    }

     @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable ("id") long id){
        return restTemplate.getForObject(prfex+"/payment/get/"+id,CommonResult.class);

    }


    @GetMapping("/getentity/{id}")
    public CommonResult<Payment> getentity(@PathVariable ("id") long id){

        ResponseEntity<CommonResult> forEntity = this.restTemplate.getForEntity(prfex + "/payment/get/" + id, CommonResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return new CommonResult<Payment>(201,"操作成功");
        }
        return new CommonResult<Payment>(400,"操作失败");


    }
}
