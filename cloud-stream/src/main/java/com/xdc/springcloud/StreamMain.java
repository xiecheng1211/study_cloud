package com.xdc.springcloud;

import com.xdc.springcloud.config.MyProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

/**
 * @author xdc
 * created by 2020/3/20
 * 在项目启动类上加上注解 @EnableBinding(value = {Processor.class}) ，表明启用 stream ，并指定定义的 Channel 定义接口类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableBinding(value = {Processor.class, MyProcessor.class})
public class StreamMain {

    public static void main(String[] args) {
        SpringApplication.run(StreamMain.class, args);
    }
}
