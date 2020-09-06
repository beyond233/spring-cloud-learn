package com.beyond233.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>项目文档: Feign相关的配置 </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-06 23:20
 */
@Configuration
public class FeignConfig {

    /**
     * 配置Feign的日志打印级别为：FULL (全部打印)
     * 该日志打印Feign接口后台调用远程服务的具体信息
     * */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}
