package com.beyond233.springcloud.service;

/**
 * 生产者消息发送接口
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-20 16:42
 */
public interface IMessageProvider {

    /**
     * 发送消息
     * @return java.lang.String
     * @since 2020/9/20 16:43
     */
    String send();
}
