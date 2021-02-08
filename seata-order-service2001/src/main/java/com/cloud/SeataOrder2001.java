package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Administrator
 * @create 2021-02-07 20:21
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动创建的配置
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrder2001 {

     //Parameter 0 of method ribbonServerList in com.alibaba.cloud.nacos.ribbon.NacosRibbonClientConfiguration required a bean of type 'com.netflix.client.config.IClientConfig' that could not be found.
     //io.seata.common.exception.FrameworkException: can not register RM,err:can not connect to services-server.
     //can not register RM,err:register error,role:TMROLE,err:cost 30002 ms
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2001.class,args);
    }
}
