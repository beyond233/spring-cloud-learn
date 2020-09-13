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
//value：调用哪个微服务的接口；fallback：指定哪个类为该service方法的fallback方法
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = FeignPaymentFallbackService.class)
@Component
public interface FeignPaymentService {

    /**
     * 超时
     * */
    @GetMapping("/provider/payment/get/timeout")
    String timeout();

}
