package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @create 2021-02-03 13:18
 */
@RestController
@RefreshScope    //开启自动刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
//        return name;
    }
}


