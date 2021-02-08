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

    /**
     * 以上三个错误的解决方法分别是:
     * 注意包名的命名  不要单层包下放引导类   应该是  com.cloud下写引导类
     * 注意依赖是否导入  本次是忘记引入druid-spring-boot-starter
     * 注意模块file.conf文件是否有误,seata的file.conf 是否有误  注意检查
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2001.class,args);
    }
}
