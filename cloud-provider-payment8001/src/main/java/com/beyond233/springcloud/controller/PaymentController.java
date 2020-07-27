package com.beyond233.springcloud.controller;

import com.beyond233.springcloud.entity.Result;
import com.beyond233.springcloud.entity.Payment;
import com.beyond233.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 服务发现
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private PaymentService paymentService;

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

    @GetMapping("/discovery")
    public Object discovery(){
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
