package com.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 自定义网关的过滤器
 * 实现 GlobalFilter, Ordered
 * 将类加入spring容器
 * @author Administrator
 * @create 2021-02-01 22:48
 */
@Component
@Slf4j
public class MyDefineFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("欢迎来到自定义的拦截器，当前时间是=====》"+new Date());
        ServerHttpRequest request = exchange.getRequest();//获取request 请求
        MultiValueMap<String, String> queryParams = request.getQueryParams();//获取请求的参数
        String username = queryParams.getFirst("username"); //请求参数中需要有username
        if(StringUtils.isEmpty(username)){
            //如果请求参数的username为空
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//设置响应的状态码，并返回
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
