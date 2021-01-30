package com.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @create 2021-01-30 20:44
 */
@Configuration
public class OpenFeignConfig {

      @Bean
       Logger.Level  openfeignlogger(){
          return Logger.Level.FULL;  //返回日志级别对象
      }
      //DynamicServerListLoadBalancer:{NFLoadBalancer:name=cloud-payment-service,current list of Servers=[192.168.1.5:8001, 192.168.1.5:8002],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;	Instance count:2;	Active connections c

}
