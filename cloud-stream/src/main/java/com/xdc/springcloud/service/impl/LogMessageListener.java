package com.xdc.springcloud.service.impl;

import com.xdc.springcloud.config.MyProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author xdc
 * created by 2020/3/20
 */
@Component
@Slf4j
public class LogMessageListener {

    /**
     * 通过 MyProcessor.MESSAGE_INPUT 接收消息
     * 然后通过 SendTo 将处理后的消息发送到 MyProcessor.LOG_FORMAT_OUTPUT
     * @param message
     * @return
     */
    @StreamListener(MyProcessor.MESSAGE_INPUT)
    @SendTo(MyProcessor.LOG_FORMAT_OUTPUT)
    public String processLogMessage(String message) {
        log.info("接收到原始消息：" + message);
        return "「" + message +"」";
    }

    /**
     * 接收来自 MyProcessor.LOG_FORMAT_INPUT 的消息
     * 也就是加工后的消息，也就是通过上面的 SendTo 发送来的
     * 因为 MyProcessor.LOG_FORMAT_OUTPUT 和 MyProcessor.LOG_FORMAT_INPUT 是指向同一 exchange
     * @param message
     */
    @StreamListener(MyProcessor.LOG_FORMAT_INPUT)
    public void processFormatLogMessage(String message) {
        log.info("接收到格式化后的消息：" + message);
    }

}
