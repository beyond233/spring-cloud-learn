package com.beyond233.springcloud.loadbalance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>项目文档: 自定义负载均衡算法实现类</p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-06 20:16
 */
@Component
@Slf4j
public class MyLoadBalancerImpl implements MyLoadBalancer {

    /**
     * 使用原子integer记录rest请求的总次数
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);


    /**
     * 返回最新的rest请求的总次数
     */
    public final int getAndIncrement() {
        //当前总的请求次数
        int current;
        //下一次请求的次数=当前总次数加1
        int next;
        do {
            current = atomicInteger.get();
            //2147483647用来判断总记录数是否越界，越界后从0开始而不是从负数
            next = current >= 2147483647 ? 0 : current + 1;
            //刷新请求总次数（使用cas修改）
        } while (!atomicInteger.compareAndSet(current, next));
        System.err.println("当前rest请求总次数：" + current);
        return next;
    }


    /**
     * 复杂均衡算法：返回一个可用服务器对象信息
     *
     * @param serviceInstances 存放了所有微服务的集合
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //根据请求总次数和总服务数取余来计算索引值，进而选择使用哪一个服务
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
