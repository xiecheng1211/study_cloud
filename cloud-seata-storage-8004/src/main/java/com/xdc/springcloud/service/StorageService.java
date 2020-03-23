package com.xdc.springcloud.service;

/**
 * @author xdc
 * created by 2020/3/23
 */
public interface StorageService {

    /**
     * 扣除存储数量
     */
    void deduct(String commodityCode, int count);

}
