package com.beyond233.springcloud.controller;

import com.beyond233.springcloud.entity.Payment;
import com.beyond233.springcloud.entity.Result;
import com.beyond233.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
public class PaymentController {

    /**服务端口*/
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    /**
     * 链路追踪
     * */
    @GetMapping("/zipkin")
    public String paymentZipkin(){
        return "payment8001-zipkin-server: 链路追踪";
    }

    /**
     * 返回当前项目的服务端口
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

    @PostMapping("/add")
    public Result<Integer> add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("添加payment 结果："+result);
        if (result>0) {
            return new Result<>(200, "添加payment成功，服务端口："+serverPort, result);
        }else{
            return new Result<>(444, "添加payment成功，服务端口："+serverPort, null);
        }
    }

    @GetMapping("/get/{id}")
    public Result<Payment> get(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询payment 结果："+payment);
        if (payment!=null) {
            return new Result<>(200, "查询payment成功，服务端口："+serverPort, payment);
        }else{
            return new Result<>(444, "查询payment失败，服务端口："+serverPort, null);
        }
    }

}
