package com.xdc.springcloud.dao;

import com.xdc.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xdc
 * created by 2020/3/18
 */
@Mapper
public interface PaymentMapper {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
