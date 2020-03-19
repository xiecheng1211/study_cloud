package com.xdc.springcloud.service.impl;

import com.xdc.springcloud.entity.CommonResult;
import com.xdc.springcloud.entity.Payment;
import com.xdc.springcloud.service.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @author xdc
 * created by 2020/3/19
 */
@Component
public class PaymentFeignServiceImpl implements PaymentFeignService {

    public CommonResult<Payment> getPayment(Long id) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(401);
        commonResult.setMessage("系统请求超时, 请稍后重试");
        return commonResult;
    }

    public CommonResult<Integer> create(Payment payment) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(401);
        commonResult.setMessage("系统请求超时, 请稍后重试");
        return commonResult;
    }
}
