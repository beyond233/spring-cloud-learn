package com.beyond233.springcloud.controller;

import com.beyond233.springcloud.entity.Payment;
import com.beyond233.springcloud.entity.Result;
import com.beyond233.springcloud.loadbalance.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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
//@EnableBinding(ConsumerSource.class)
public class OrderController {

    /**
     * 单机版：
     * 8001payment服务的接口
     * */
    public static final String PAYMENT_URL = "http://localhost:8002";
    /**
     * 集群版：
     * 集群下的访问路径应写服务的公共实例名称，即在yml文件配置的spring.application.name
     * 用户不应像上面单机版那样关注服务具体的url和端口号，而是只关注与对应服务的公共实例名称。
     * */
//    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyLoadBalancer myLoadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 链路追踪
     * */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin", String.class);
    }

    /**
     * 远程调用添加payment的服务接口
     * */
    @GetMapping("/payment/add")
    public Result<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,Result.class);
    }

    /**
     * 远程调用通过id获取payment的服务接口
     * */
    @GetMapping("/payment/get/{id}")
    public Result<Payment> get(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, Result.class);
    }

    /**
     * 通过id获取响应实体
     * */
    @GetMapping("/payment/getForEntity/{id}")
    public Result<Payment> getEntity(@PathVariable("id") Integer id){
        ResponseEntity<Result> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, Result.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else{
            return new Result<Payment>(444, "操作失败");
        }

    }


    /**
     * 接收MQ消息
     * */
//    @StreamListener(value = ConsumerSource.INPUT)
//    public void testListener(Message message){
//        System.err.println(message.getPayload().toString());
//    }

    /**
     * 根据复杂均衡算法获得某一个服务的端口
     * */
    @GetMapping("/payment/lb")
    public String getLoadBalance(){
        //根据服务名获取其所属的全部服务
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        //通过负载均衡算法从全部服务中选择一个可用的服务
        ServiceInstance serviceInstance = myLoadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        //远程访问获取对应服务的端口的接口
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
