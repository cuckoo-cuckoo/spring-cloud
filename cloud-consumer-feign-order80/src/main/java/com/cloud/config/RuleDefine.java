package com.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @create 2021-02-01 11:31
 */
@Configuration
public class RuleDefine {

    @Bean
    public IRule iRule(){
        return new RoundRobinRule();  //设置为轮询算法
    }
}
