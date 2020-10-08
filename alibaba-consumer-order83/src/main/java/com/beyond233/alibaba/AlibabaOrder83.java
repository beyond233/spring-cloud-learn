package com.beyond233.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/5 23:49
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaOrder83 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaOrder83.class, args);
    }
}
