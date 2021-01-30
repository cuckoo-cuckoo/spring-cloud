package com.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @create 2021-01-29 17:43
 */
@SpringBootApplication
@MapperScan(basePackages ="com.cloud.dao")
@EnableDiscoveryClient
public class PayMentApplication8002 {


    public static void main(String[] args) {
        SpringApplication.run(PayMentApplication8002.class,args);
    }
}
