package com.xdc.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xdc
 * created by 2020/3/23
 *
 * CREATE TABLE `order_tbl` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `user_id` varchar(255) DEFAULT NULL,
 *   `commodity_code` varchar(255) DEFAULT NULL,
 *   `count` int(11) DEFAULT '0',
 *   `money` int(11) DEFAULT '0',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;

}
