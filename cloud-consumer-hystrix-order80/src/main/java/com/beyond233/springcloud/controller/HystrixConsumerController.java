package com.beyond233.springcloud.controller;

import com.beyond233.springcloud.service.FeignPaymentService;
import com.mysql.jdbc.TimeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-09 0:07
 */
@RestController
@RequestMapping("/consumer/payment")
@DefaultProperties(defaultFallback = "commonFallback")//设置默认的全局Fallback方法
public class HystrixConsumerController {

    @Autowired
    private FeignPaymentService feignPaymentService;


    /**
     * 模拟服务调用错误
     * */
    @HystrixCommand
    @RequestMapping("/get/error")
    public String error(){
        int a = 0 / 0;
        return "error";
    }

    /**
     * 模拟超时或运行异常服务
     * */
    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="8000")//超时3秒就触发fallback
    })
    @RequestMapping("/get/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return feignPaymentService.timeout();
    }

    /**
     * 服务降级方法
     * */
    public String timeoutHandler(){
        return "客户端---timeoutHandler进行专属的服务访问降级保护";
    }

    /**
     * 公共服务降级处理方法
     * */
    public String commonFallback(){
        return "客户端-----公共服务降级";
    }

}
