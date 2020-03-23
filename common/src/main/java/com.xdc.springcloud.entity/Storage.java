package com.xdc.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xdc
 * created by 2020/3/23
 *
 * CREATE TABLE `storage_tbl` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `commodity_code` varchar(255) DEFAULT NULL,
 *   `count` int(11) DEFAULT '0',
 *   PRIMARY KEY (`id`),
 *   UNIQUE KEY `commodity_code` (`commodity_code`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {

    private Integer id;

    private String commodityCode;

    private Integer count;

}
