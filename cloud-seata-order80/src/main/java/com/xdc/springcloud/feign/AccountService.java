package com.xdc.springcloud.feign;

/**
 * @author xdc
 * created by 2020/3/23
 */
public interface AccountService {

    void debit(String userId, int money);
}
