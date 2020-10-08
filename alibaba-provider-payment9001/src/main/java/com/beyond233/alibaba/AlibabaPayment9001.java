package com.beyond233.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述: 启动类
 *
 * @author beyond233
 * @since 2020/10/5 18:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPayment9001 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9001.class, args);
    }
}
