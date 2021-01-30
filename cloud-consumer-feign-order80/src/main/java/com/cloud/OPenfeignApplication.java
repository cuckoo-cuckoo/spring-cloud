package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 * @create 2021-01-30 18:06
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OPenfeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OPenfeignApplication.class,args);
    }
}
