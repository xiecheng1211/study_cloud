package com.xdc.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.xdc.springcloud.entity.CommonResult;
import com.xdc.springcloud.entity.Payment;
import com.xdc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xdc
 * created by 2020/3/18
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/get/{id}")
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

    @GetMapping("/discoveryClient")
    public void discoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String serviceStr : services) {
            log.info(" service ---- " + serviceStr);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-PROVIDER");
        for (ServiceInstance instance : instances){
            log.info(instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getServiceId() + "\t" + instance.getInstanceId());
        }
    }

}
