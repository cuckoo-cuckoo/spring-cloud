package com.cloud.balance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Administrator
 * @create 2021-01-30 17:07
 */
public interface LoadBalancer {

    //收集服务器有多少台能够提供服务的机器，并放入List集合
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
