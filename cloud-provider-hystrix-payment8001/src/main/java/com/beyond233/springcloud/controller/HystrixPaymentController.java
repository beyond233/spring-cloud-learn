package com.beyond233.springcloud.controller;

import com.beyond233.springcloud.service.HystrixPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-07 21:43
 */
@RestController
@RequestMapping("/provider")
public class HystrixPaymentController {

    @Autowired
    private HystrixPaymentService hystrixPaymentService;

    /**
     * 模拟正常服务
     * */
    @GetMapping("/payment/get/ok")
    public String ok(){
        return "ok";
    }

    /**
     * 模拟超时或运行异常服务
     * */
    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")//超时3秒就触发fallback
    })
    @GetMapping("/payment/get/timeout")
    public String timeout(){
        int a = 10 / 0;
        try {
            //模拟业务处理时间超过5秒
//            TimeUnit.SECONDS.sleep(5);
            //模拟业务运行时发生异常
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "timeout end";
    }

    /**
     *  hystrix服务降级方法
     *
     *  /consumer/payment/get/timeout服务发生异常时的处理方法
     * */
    public String timeoutHandler(){
        return "payment服务端--/consumer/payment/get/timeout运行超时，o(╥﹏╥)o....." +"\n"+
                "服务端将进行服务降级，服务异常处理。。。。";
    }

    /**
     * hystrix服务熔断
     * */
    @RequestMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable Integer id){
        return hystrixPaymentService.circuit(id);
    }


}
