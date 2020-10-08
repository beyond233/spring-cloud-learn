package com.beyond233.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 描述: nacos配置中心启动类
 *
 * @author beyond233
 * @since 2020/10/6 12:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConfig3377 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaConfig3377.class, args);
    }
}
