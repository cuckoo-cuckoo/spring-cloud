package com.cloud;

import com.myrule.Myrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Administrator
 * @create 2021-01-30 16:33
 */
@SpringBootApplication
//@RibbonClient(value = "cloud-payment-service",configuration =Myrule.class)
public class Consumer801Application {


    public static void main(String[] args) {
        SpringApplication.run(Consumer801Application.class,args);
    }
}
