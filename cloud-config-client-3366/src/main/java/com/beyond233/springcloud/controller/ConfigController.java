package com.beyond233.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取GitHub上配置中心的配置信息
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-19 18:26
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    /**
     * 读取服务器端口信息
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * 远程读取配置中心的配置信息
     * */
    @Value("${config.info}")
    private String info;

    @GetMapping("/info")
    public String getInfo(){
        return serverPort+"-----"+info;
    }

}
