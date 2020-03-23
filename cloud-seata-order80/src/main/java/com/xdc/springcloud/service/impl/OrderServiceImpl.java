package com.xdc.springcloud.service.impl;

import com.xdc.springcloud.dao.OrderDao;
import com.xdc.springcloud.entity.Order;
import com.xdc.springcloud.feign.AccountService;
import com.xdc.springcloud.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author xdc
 * created by 2020/3/23
 */
@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    private AccountService accountService;

    public Order create(String userId, String commodityCode, int orderCount, int money) {


        accountService.debit(userId, money);

        Order order = new Order();
        order.setCommodityCode(commodityCode);
        order.setUserId(userId);
        order.setCount(orderCount);
        order.setMoney(money);

        // INSERT INTO orders ...
        return orderDao.insert(order);
    }
}
