package com.beyond233.springcloud.service;

import com.beyond233.springcloud.entity.Payment;
import com.beyond233.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-06 22:25
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface FeignPaymentService {

    /**
     * 绑定远程查询服务
     */
    @GetMapping("/payment/get/{id}")
    Result<Payment> get(@PathVariable("id") Long id);

    /**
     * 超时
     * */
    @GetMapping("/payment/feign/timeout")
    public String timeout();

}
