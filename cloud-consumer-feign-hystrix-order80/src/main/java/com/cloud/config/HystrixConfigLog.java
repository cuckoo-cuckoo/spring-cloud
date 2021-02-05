package com.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @create 2021-01-31 14:59
 */
@Configuration
public class HystrixConfigLog {

        @Bean
         public Logger.Level logg(){
             return Logger.Level.FULL;
         }
}
