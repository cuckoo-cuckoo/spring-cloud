package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 * @create 2021-02-09 0:02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelApplication9002 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication9002.class,args);
    }
}
