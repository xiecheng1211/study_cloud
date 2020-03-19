package com.xdc.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xdc.springcloud.entity.CommonResult;
import com.xdc.springcloud.entity.Payment;
import com.xdc.springcloud.service.impl.PaymentFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author xdc
 * created by 2020/3/19
 */
@Component
@FeignClient(value = "PAYMENT-PROVIDER", primary = false, fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);

    @PostMapping("/save")
    public CommonResult<Integer> create(Payment payment);
}
