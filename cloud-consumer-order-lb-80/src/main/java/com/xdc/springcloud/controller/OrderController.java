package com.xdc.springcloud.controller;

import com.xdc.springcloud.entity.CommonResult;
import com.xdc.springcloud.entity.Payment;
import com.xdc.springcloud.lb.MyLB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author xdc
 * created by 2020/3/18
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private MyLB myLB;

    private final String serviceId = "payment-provider";

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(getHost() + "/payment/get/" + id, CommonResult.class);
    }

    @PostMapping("/save")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(getHost() + "/payment/save",  payment, CommonResult.class);
    }

    private String getHost() {
        return getService().getHost() + ":" + getService().getPort();
    }

    private ServiceInstance getService() {
        return myLB.loadBanlance(discoveryClient.getInstances(serviceId));
    }

}
