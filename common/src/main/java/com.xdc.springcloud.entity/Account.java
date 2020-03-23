package com.xdc.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xdc
 * created by 2020/3/23
 * CREATE TABLE `account_tbl` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `user_id` varchar(255) DEFAULT NULL,
 *   `money` int(11) DEFAULT '0',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    private Integer id;

    private String userId;

    private Integer money;
}
