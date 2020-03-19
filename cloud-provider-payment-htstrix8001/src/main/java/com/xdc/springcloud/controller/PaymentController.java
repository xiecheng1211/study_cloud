package com.xdc.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xdc.springcloud.entity.CommonResult;
import com.xdc.springcloud.entity.Payment;
import com.xdc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xdc
 * created by 2020/3/19
 */
@RestController
@Slf4j
public class PaymentController {


    @Autowired
    private PaymentService paymentService;


    /**
     * 熔断信息设置，设置熔断请求超时时间信息
     * */
    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentFollback", commandProperties = {
            //超时时间限制
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
            //是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //请求次数信息
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //时间窗口期  (在一定时间范围之内)
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //失败率达到多少是进行熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        CommonResult<Payment> build = CommonResult.<Payment>builder().build();
        if (id == null) {
            build.setCode(401);
            build.setMessage("参数信息错误");
            return build;
        }
        Payment payment = paymentService.getPaymentById(id);
        if (payment == null) {
            build.setCode(402);
            build.setMessage("请求对象不存在");
            return build;
        }
        build.setCode(200);
        build.setMessage("success");
        build.setData(payment);
        return build;
    }

    /**
     * 熔断降级请求信息
     * */
    private CommonResult<Payment> getPaymentFollback(Long id) {
        CommonResult<Payment> build = CommonResult.<Payment>builder().build();
        build.setCode(411);
        build.setMessage("系统繁忙请稍后重试");
        build.setData(null);
        return build;
    }

    @PostMapping("/save")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
        log.info("****** 插入数据结果: " + result);
        if (result > 0) {
            return new CommonResult<Integer>(200, "success", result);
        }else {
            return new CommonResult<Integer>(400, "fail", result);
        }
    }

}
