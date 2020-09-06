package com.beyond233.springcloud.controller;

import com.beyond233.springcloud.entity.Payment;
import com.beyond233.springcloud.entity.Result;
import com.beyond233.springcloud.rocketmq.ProducerSource;
import com.beyond233.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.aggregator.MessageGroupExpiredEvent;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 20:53
 */
@RestController
@RequestMapping("/payment")
@Slf4j
@EnableBinding(ProducerSource.class)
public class PaymentController {

    /**
     * 服务端口
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * 服务发现
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProducerSource producerSource;


    /**
     * 返回当前项目的服务端口
     * 用于构建自己手写实现的负载均衡算法
     * */
    @GetMapping("/lb")
    public String getLoadBalancePort(){
        return serverPort;
    }

    /**
     * 模拟处理时间较长的业务
     * */
    @GetMapping("/feign/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    /**
     * 添加
     */
    @PostMapping("/add")
    public Result<Integer> add(@RequestBody Payment payment) {
        int result = paymentService.add(payment);
        log.info("添加payment 结果：" + result);
        if (result > 0) {
            return new Result<>(200, "添加payment成功，服务端口：" + serverPort, result);
        } else {
            return new Result<>(444, "添加payment成功，服务端口：" + serverPort, null);
        }
    }

    /**
     * 查询
     */
    @GetMapping("/get/{id}")
    public Result<Payment> get(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询payment 结果：" + payment);
        if (payment != null) {
            Message<String> message = MessageBuilder.withPayload("生产者发送数据")
                    .setHeader(RocketMQHeaders.TAGS, "8001").build();
            producerSource.paymentProducer().send(message);
            return new Result<>(200, "查询payment成功，服务端口：" + serverPort, payment);
        } else {
            return new Result<>(444, "查询payment失败，服务端口：" + serverPort, null);
        }
    }

    /**
     * 发现服务
     */
    @GetMapping("/discovery")
    public Object discovery() {
        //获取该服务端口下的所有服务信息
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        //获取该服务公共实例名称下的所有服务实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return discoveryClient;
    }


}
