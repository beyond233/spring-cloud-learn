package com.beyond233.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>项目文档:  自定义Ribbon负载均衡规则类
 *              该类所在包不能再主启动类所在包及子包下
 * </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-06 19:06
 */
@Configuration
public class MyLoadBalanceRule {
    @Bean
    public IRule myRule(){
        //采用随机规则
        return new RandomRule();
    }
}
