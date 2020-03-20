package com.xdc.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author xdc
 * created by 2020/3/20
 *
 * 编码实现路由规则 和 yml中配置效果一样
 */
public class GatewayConfig {


    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("payment",
                r -> r.path("/payment")
                    .uri("http://localhost:8001")).build();
        return routes.build();
    }
}
