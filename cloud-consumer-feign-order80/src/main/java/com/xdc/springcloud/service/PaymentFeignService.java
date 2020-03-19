package com.xdc.springcloud.service;

import com.xdc.springcloud.entity.CommonResult;
import com.xdc.springcloud.entity.Payment;
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
@FeignClient(value = "PAYMENT-PROVIDER", primary = false)
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);

    @PostMapping("/save")
    public CommonResult<Integer> create(Payment payment);
}
