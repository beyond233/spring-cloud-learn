package com.beyond233.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@SpringBootApplication
public class Payment8002Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002Application.class,args);
    }
}
