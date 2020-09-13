package com.beyond233.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-10 23:23
 */
@Service
public class HystrixPaymentService {

    /**
     * 服务熔断方法
     * */
    @HystrixCommand(fallbackMethod = "circuitHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//最大错误请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String circuit(@PathVariable Integer id){
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        String uuid = IdUtil.simpleUUID();
        return "payment-circuit服务调用成功!  流水号为：" + uuid;
    }

    /**
     * 服务熔断Fallback
     */
    public String circuitHandler(@PathVariable Integer id) {
        return "payment服务端进行服务熔断处理---" + "id: " + id;
    }
}
