package com.beyond233.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/8 20:30
 */
@Configuration
@MapperScan("com.beyond233.alibaba.mapper")
public class MybatisConfig {
}
