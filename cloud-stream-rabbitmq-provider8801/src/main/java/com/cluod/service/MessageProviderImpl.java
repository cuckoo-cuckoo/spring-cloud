package com.cluod.service;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 消息的发送者    source
 * @author Administrator
 * @create 2021-02-03 22:49
 */
@EnableBinding(Source.class)//定义消息的推送管道   就是将队列与交换机绑定
public class MessageProviderImpl  {

    @Resource
    private MessageChannel output;//消息发送管道   用于发送消息   output不要变否则会出错

    public String send() {
        String s = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(s).build());
        System.out.println("*****serial: "+s);
        return s;
    }
}
