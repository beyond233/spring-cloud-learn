package com.beyond233.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author beyond233
 * @since 2020/10/5 13:06
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer8803.class, args);
    }
}
