package com.beyond233.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p>项目文档: 自己手写实现的负载均衡算法</p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-06 20:12
 */
public interface MyLoadBalancer {
    /**
     * 返回某个服务器实例对象
     * @param serviceInstances 服务器实例对象集合
     * @return org.springframework.cloud.client.ServiceInstance
     * @since 2020/9/6 20:15
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
