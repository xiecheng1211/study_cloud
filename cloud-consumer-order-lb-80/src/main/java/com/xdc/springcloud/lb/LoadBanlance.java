package com.xdc.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author xdc
 * created by 2020/3/19
 */
public interface LoadBanlance {

    ServiceInstance loadBanlance(List<ServiceInstance> serviceInstanceList);

}
