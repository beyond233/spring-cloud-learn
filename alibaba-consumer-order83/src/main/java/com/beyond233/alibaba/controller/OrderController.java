package com.beyond233.alibaba.controller;

import com.beyond233.alibaba.rpc.PaymentRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/5 23:50
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private PaymentRpc paymentRpc;

    @GetMapping("/{id}")
    public String getOrder(@PathVariable("id") Integer id) {
        return paymentRpc.getPayment(id);
    }

}
