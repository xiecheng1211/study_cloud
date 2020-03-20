package com.xdc.springcloud.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author xdc
 * created by 2020/3/20
 * 表示消息来源 也就是发送者
 *  stream 内置的简单消息通道（消息通道也就是指消息的来源和去向）接口定义，一个 Source 和 一个 Sink 。
 */
public interface Source {

    String output = "output";

    @Output("output")
    MessageChannel output();

}
