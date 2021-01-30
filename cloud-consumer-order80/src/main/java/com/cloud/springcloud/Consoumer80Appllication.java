package com.cloud.springcloud;

import com.cloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @create 2021-01-29 21:16
 */
@SpringBootApplication
@EnableDiscoveryClient
//修改负载均衡的默认算法
@RibbonClient(name="cloud-payment-service",configuration = MySelfRule.class)
public class Consoumer80Appllication {

    public static void main(String[] args) {
        SpringApplication.run(Consoumer80Appllication.class,args);
    }

    @Bean
    @LoadBalanced   //RestTemplate使用负载均衡   默认轮询算法
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
