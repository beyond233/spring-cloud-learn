package com.beyond233.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-20 17:44
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumer8802.class, args);
    }
}
