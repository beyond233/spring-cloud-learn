package com.beyond233.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 描述: 8803消费者消费消息controller
 *
 * @author beyond233
 * @since 2020/10/5 13:11
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class StreamListenerController {

    /**
     * server port
     */
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void consume(Message<String> msg){
        log.info(serverPort + " 消费消息: " + msg.getPayload());
    }
}
