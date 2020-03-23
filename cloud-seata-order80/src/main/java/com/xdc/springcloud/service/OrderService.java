package com.xdc.springcloud.service;

import com.xdc.springcloud.entity.Order;

/**
 * @author xdc
 * created by 2020/3/23
 */
public interface OrderService {

    /**
     * 创建订单
     */
    Order create(String userId, String commodityCode, int orderCount);

}
