package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @create 2021-01-30 16:35
 */
@Configuration
public class Myrule {

    @Bean
    public IRule makerule(){

        return new RandomRule();
    }
}
