package com.xdc.springcloud.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Component;

/**
 * @author xdc
 * created by 2020/3/20
 *
 */
@Slf4j
@Component
public class DefaultMessageListener {

    /**
     * 在方法 processMyMessage() 上使用 @StreamListener 注解，
     * 表示对消息进行订阅监控，指定 binding 的名称，
     * 其中 Processor.INPUT 就是 Sink 的 input ，
     * 也就是字符串 input ,对应配置文件中的输入方，
     * 就是 spring.cloud.stream.bindings.input。
     *
     * 启动 DefaultApplication ，
     * 可以在 rabbitmq 管理控制台的 exchanges 中看到增加的这几个 bindings 。
     * */
    @StreamListener(Processor.INPUT)
    public void processMyMessage(String message) {
        log.info("接收到消息：" + message);
    }

}
