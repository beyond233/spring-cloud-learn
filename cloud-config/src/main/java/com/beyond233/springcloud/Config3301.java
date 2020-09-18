package com.beyond233.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * spring cloud config 配置中心主启动类
 *
 * @author XuJie
 * @date 2020/9/16 11:00
 */
@SpringBootApplication
@EnableConfigServer
public class Config3301 {
    public static void main(String[] args) {
        SpringApplication.run(Config3301.class, args);
    }
}
