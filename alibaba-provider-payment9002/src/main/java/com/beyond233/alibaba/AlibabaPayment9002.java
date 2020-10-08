package com.beyond233.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/5 23:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaPayment9002.class, args);
    }
}
