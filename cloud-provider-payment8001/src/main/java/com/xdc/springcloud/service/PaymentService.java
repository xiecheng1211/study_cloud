package com.xdc.springcloud.service;

import com.xdc.springcloud.dao.PaymentMapper;
import com.xdc.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xdc
 * created by 2020/3/18
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    public int save(Payment payment) {
        return paymentMapper.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

}
