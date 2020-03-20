package com.xdc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xdc
 * created by 2020/3/20
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain.class, args);
    }
}
