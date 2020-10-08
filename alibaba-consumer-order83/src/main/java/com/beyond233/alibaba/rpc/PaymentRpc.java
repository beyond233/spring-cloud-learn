package com.beyond233.alibaba.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 描述: alibaba-payment-service rpc接口
 *
 * @author beyond233
 * @since 2020/10/5 23:50
 */
@Service
@FeignClient("alibaba-payment-service")
public interface PaymentRpc {

    /**
     * payment rpc接口
     *
     * @param id id
     * @return { {@link String}}
     * @author beyond233
     * @since 2020/10/6 0:39
     */
    @GetMapping("/payment/{id}")
    String getPayment(@PathVariable("id") Integer id);
}
