package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Administrator
 * @create 2021-02-04 21:55
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosConfigClientMain3377
{
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigClientMain3377.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.err.println("user name :"+userName+"; age: "+userAge);
    }

    //启动出错：The bean 'nacosRefreshProperties', defined in class path resource [com/alibaba/cloud/nacos/NacosConfigAutoConfiguration.class], could not be registered. A bean with that name has already been defined in URL [jar:file:/D:/Program%20Files/apache/maven-repository/com/alibaba/cloud/spring-cloud-alibaba-nacos-config/2.1.0.RELEASE/spring-cloud-alibaba-nacos-config-2.1.0.RELEASE.jar!/com/alibaba/cloud/nacos/refresh/NacosRefreshProperties.class] and overriding is disabled.
}


