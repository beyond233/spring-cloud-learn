package com.beyond233.springcloud.service.impl;

import com.alibaba.fastjson.JSON;
import com.beyond233.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * 消息生产者实现
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-20 16:44
 */
@Slf4j
@EnableBinding(Source.class)  //定义消息的生产管道
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 注入具体的消息生产管道
     * */
    @Autowired
    private MessageChannel output;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 生产者发送消息方法的具体实现
     * */
    @Override
    public String send() {
        String msg = "哈哈哈，生产者发送消息--" + serverPort;
        String s = JSON.toJSONString(msg);
        output.send(MessageBuilder.withPayload(s).build());
        log.info("发送了一条消息： " + msg);
        return null;
    }
}
