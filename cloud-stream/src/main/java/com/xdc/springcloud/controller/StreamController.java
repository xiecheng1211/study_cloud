package com.xdc.springcloud.controller;

import com.xdc.springcloud.config.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xdc
 * created by 2020/3/20
 */
@RestController
public class StreamController {

    @Autowired
    private MyProcessor myProcessor;

    /**
     * 发送消息
     * */
    @GetMapping(value = "/sendLogMessage")
    public void sendLogMessage(String message){
        Message<String> stringMessage = MessageBuilder.withPayload(message).build();
        myProcessor.logOutput().send(stringMessage);
    }


}
