package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 * @create 2021-02-09 0:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApllication9003 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApllication9003.class,args);
    }
}
