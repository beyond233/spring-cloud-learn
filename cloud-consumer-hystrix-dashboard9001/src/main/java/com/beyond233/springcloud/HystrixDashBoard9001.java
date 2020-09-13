package com.beyond233.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *  开启hystrix-dashboard图形监控平台
 *   浏览器中输入http://ip:port/hystrix即可访问
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-13 13:33
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashBoard9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoard9001.class, args);
    }
}
