package com.xdc.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xdc
 * created by 2020/3/19
 */
@Component
public class MyLB implements LoadBanlance{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAtomicInteger() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("---------当前第" + next + "访问数据信息");
        return next;
    }

    public ServiceInstance loadBanlance(List<ServiceInstance> serviceInstanceList) {

        if (serviceInstanceList == null || serviceInstanceList.size() == 0) {
            return null;
        }
        int size = serviceInstanceList.size();
        return serviceInstanceList.get(getAtomicInteger() % size);
    }
}
