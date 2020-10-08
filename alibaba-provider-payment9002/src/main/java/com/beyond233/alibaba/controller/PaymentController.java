package com.beyond233.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/5 23:41
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;


    @GetMapping("/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "cloud-alibaba-payment-service(" + serverPort +
                "): your id is " + id;
    }
}
