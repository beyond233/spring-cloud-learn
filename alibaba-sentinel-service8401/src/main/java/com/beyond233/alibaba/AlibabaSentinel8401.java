package com.beyond233.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 描述: AlibabaSentinel8401启动类
 *
 * @author beyond233
 * @since 2020/10/11 13:33
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AlibabaSentinel8401 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinel8401.class, args);
    }
}