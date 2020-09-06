package com.beyond233.springcloud;

import com.beyond233.rule.MyLoadBalanceRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 21:27
 */
//@EnableEurekaClient注解表明这是一个Eureka客户端，用来消费服务的
@EnableEurekaClient
//开启rocketmq的消费者和生产者绑定
@EnableBinding({Source.class, Sink.class})
//加载自定义的负载均衡规则
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyLoadBalanceRule.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Order80Application {
    public static void main(String[] args) {
        SpringApplication.run(Order80Application.class, args);
    }
}
