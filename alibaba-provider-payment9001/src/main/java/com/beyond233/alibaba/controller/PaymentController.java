package com.beyond233.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:  payment controller class (spring cloud alibaba)
 *
 * @author beyond233
 * @since 2020/10/5 18:45
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "cloud-alibaba-payment-service(" + serverPort +
                "): your id is " + id;
    }
}
