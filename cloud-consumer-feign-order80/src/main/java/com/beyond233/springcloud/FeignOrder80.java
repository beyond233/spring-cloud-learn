package com.beyond233.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-06 22:03
 */
//激活开启feign
@EnableFeignClients
@SpringBootApplication
public class FeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrder80.class, args);
    }
}
