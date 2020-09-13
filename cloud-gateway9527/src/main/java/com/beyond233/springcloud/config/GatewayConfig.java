package com.beyond233.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-13 20:12
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置路由映射：
     * 当访问localhost:9527/guonei的时候会将请求转发到 http://news.baidu.com/guonei
     * */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path-route-beyond",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();

    }
}
