package com.xdc.springcloud.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xdc
 * created by 2020/3/20
 * 表示消息接收者
 * 消息接收通道定义，定义了一个 SubscribableChannel 类型的 input() 方法，表示订阅一个消息的方法，并用 @Input 注解标识，并且指定了 binging 的名称为 input 。
 */
public interface Sink {

    String input = "input";

    @Input("input")
    SubscribableChannel input();
}
