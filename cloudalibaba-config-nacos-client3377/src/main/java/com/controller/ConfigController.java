package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @create 2021-02-06 21:14
 */
@RestController
@RequestMapping("/config")
@RefreshScope     //通过 Spring Cloud 原生注解 @RefreshScope 实现配置自动更新
public class ConfigController {

    @Value("${user.name}")
    private String name;

    @RequestMapping("/get")
    public String get() {
        return name;
    }
}
