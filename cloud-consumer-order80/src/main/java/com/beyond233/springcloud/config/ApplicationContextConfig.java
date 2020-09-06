package com.beyond233.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 21:33
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 注入Restful服务访问模板类
     *
     * 使用LoadBalanced注解赋予RestTemplate负载均衡的能力，即可以通过服务的公共实例名称来访问其对应的具体的服务
     * 即通过CLOUD-PAYMENT-SERVICE可以访问其对应的8001和8002服务端口
     * */
//    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
