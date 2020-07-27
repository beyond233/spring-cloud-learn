package com.beyond233.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 21:05
 */
@Configuration
@MapperScan("com.beyond233.springcloud.mapper")
public class MyBatisConfig {
}
