package com.xdc.springcloud.service;

/**
 * @author xdc
 * created by 2020/3/23
 */
public interface AccountService {

    /**
     * 从用户账户中借出
     */
    void debit(String userId, int money);

}
