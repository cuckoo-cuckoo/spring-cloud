package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @create 2021-01-30 2:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Consumer80Apllication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80Apllication.class,args);
    }
}
