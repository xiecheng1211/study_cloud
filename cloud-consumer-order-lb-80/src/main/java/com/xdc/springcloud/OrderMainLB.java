package com.xdc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xdc
 * created by 2020/3/19
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class OrderMainLB {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainLB.class, args);
    }
}
