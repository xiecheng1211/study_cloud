package com.xdc.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xdc
 * created by 2020/3/19
 */
@Configuration
public class FeignConfig {

    /**
     * feign的日志级别信息
     * */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
