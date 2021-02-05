package com.cluod.controller;

import com.cluod.service.MessageProviderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @create 2021-02-03 22:59
 */
@RestController
public class SendMessageController {


    @Resource
    private MessageProviderImpl messageProvider;
    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }

}
