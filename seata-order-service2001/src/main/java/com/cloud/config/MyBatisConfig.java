package com.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @create 2021-02-07 21:53
 */
@Configuration
@MapperScan("com.cloud.dao")
public class MyBatisConfig {


}

