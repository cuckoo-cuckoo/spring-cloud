package com.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @create 2021-01-30 16:33
 */
@Configuration
public class ResttemplateConfig {
    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }
}
