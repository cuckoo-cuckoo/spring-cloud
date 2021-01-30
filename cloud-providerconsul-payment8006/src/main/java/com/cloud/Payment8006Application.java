package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @create 2021-01-30 2:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8006Application {
    public static void main(String[] args) {
      SpringApplication.run(Payment8006Application.class,args);
    }
}
