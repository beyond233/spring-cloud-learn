package com.beyond233.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义实现gateway网关过滤器，相比在配置文件里使用固定参数配置更为灵活
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-14 23:46
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {


    /**
     * 过滤器实现： 访问路径必须携带名称的username的请求参数，不携带将不能访问微服务
     * */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 从request中获取名称为username的请求参数
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        // 判断username是否为空
        if (username == null) {
            log.info("参数username不能为空！！！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        // 通过请求，转发路由
        return chain.filter(exchange);
    }

    /**
     * 顺序规则
     * */
    @Override
    public int getOrder() {
        return 0;
    }
}
