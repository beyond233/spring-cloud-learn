package com.beyond233.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * 在FeignService接口方法的基础上构造对应的服务熔断Fallback方法
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-09 22:50
 */
@Service
public class FeignPaymentFallbackService implements FeignPaymentService {

    @Override
    public String timeout() {
        return "客户端服务异常---FeignServiceFallBack进行服务降级";
    }
}
