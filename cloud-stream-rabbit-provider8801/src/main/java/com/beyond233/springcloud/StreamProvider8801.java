package com.beyond233.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-20 16:41
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamProvider8801.class, args);
    }
}
