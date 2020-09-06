package com.beyond233.springcloud.controller;

import com.beyond233.springcloud.entity.Payment;
import com.beyond233.springcloud.entity.Result;
import com.beyond233.springcloud.service.FeignPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-06 22:33
 */
@RestController
@RequestMapping("/consumer")
public class FeignOrderController {

    @Autowired
    private FeignPaymentService feignPaymentService;

    /**
     * 查询
     */
    @GetMapping("/payment/get/{id}")
    public Result<Payment> get(@PathVariable Long id){
        //通过feign调用远程服务
        return feignPaymentService.get(id);
    }

    /**
     * 超时
     * */
    @GetMapping("/payment/feign/timeout")
    public String timeout(){
        //默认Feign客户端等待响应时只等待一秒钟，但是要访问的远程服务需要花费三秒钟，此时客户端等待超时直接返回报错
        //为了避免这种情况，应该在yml文件中进行相应配置
        return feignPaymentService.timeout();
    }



}
