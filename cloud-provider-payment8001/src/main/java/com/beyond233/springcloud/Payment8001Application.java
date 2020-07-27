package com.beyond233.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>项目文档: 主启动类</p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 18:23
 */

//@EnableEurekaClient注解表明这是一个Eureka客户端，用来向消费者提供服务的
@EnableEurekaClient
//EnableDiscoveryClient注解表明可以通过discoveryClient获取相应的服务信息
@EnableDiscoveryClient
@SpringBootApplication
public class Payment8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001Application.class,args);
    }
}
