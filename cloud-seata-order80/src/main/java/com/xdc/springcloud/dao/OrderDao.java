package com.xdc.springcloud.dao;

import com.xdc.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xdc
 * created by 2020/3/23
 */
@Mapper
public interface OrderDao {


    Order insert(Order order);
}
