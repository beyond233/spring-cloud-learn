package com.beyond233.springcloud.controller;

import com.beyond233.springcloud.entity.Payment;
import com.beyond233.springcloud.entity.Result;
import com.beyond233.springcloud.rocketmq.ConsumerSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 21:29
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
@EnableBinding(ConsumerSource.class)
public class OrderController {

    /**
     * 单机版：
     * 8001payment服务的接口
     * */
//    public static final String PAYMENT_URL = "http://localhost:8001";
    /**
     * 集群版：
     * 集群下的访问路径应写服务的公共实例名称，即在yml文件配置的spring.application.name
     * 用户不应像上面单机版那样关注服务具体的url和端口号，而是只关注与对应服务的公共实例名称。
     * */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用8001添加payment的服务接口
     * */
    @GetMapping("/payment/add")
    public Result<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,Result.class);
    }

    /**
     * 调用8001通过id获取payment的服务接口
     * */
    @GetMapping("/payment/get/{id}")
    public Result<Payment> get(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, Result.class);
    }

    @StreamListener(value = ConsumerSource.INPUT)
    public void testListener(Message message){
        System.err.println(message.getPayload().toString());
    }


}
