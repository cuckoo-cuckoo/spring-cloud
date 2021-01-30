package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @create 2021-01-30 1:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerzkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerzkApplication.class,args);
    }
}
