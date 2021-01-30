package com.cloud.balance;

import lombok.experimental.var;
import org.aspectj.weaver.ast.Var;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 * @create 2021-01-30 17:06
 */
@Component
public class Mybalance implements LoadBalancer  {

    //算法的关键是   访问次数%提供服务的机器台数
    private AtomicInteger atomicInteger = new AtomicInteger(0);
       //坐标
        private final int getAndIncrement(){
               int current;
               int next;
               do{
                     current = this.atomicInteger.get();
                   next = current >= 2147483647 ? 0 : current + 1;

               }while(!this.atomicInteger.compareAndSet(current,next));//第一个参数是期望值，第二个参数是修改值
            System.out.println("=========第几次访问，次数next是=======》"+next);
            return next;
        }
    //得到机器的列表
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
           int size= getAndIncrement()%serviceInstances.size();//得到服务器的下标
        return serviceInstances.get(size);
    }
}
