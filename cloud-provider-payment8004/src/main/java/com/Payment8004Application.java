package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @create 2021-01-30 0:49
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8004Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment8004Application.class,args);
    }
}
