package com.beyond233.cloud.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * rabbitmq 消费者
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-20 17:51
 */
@RestController
@EnableBinding(Sink.class)
@Slf4j
public class ConsumerController {

    /**
     * 服务端口
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * 消息监听
     */
    @StreamListener(Sink.INPUT)
    private void consume(Message<String> msg) {
        String s = msg.getPayload();
        String message = JSON.toJavaObject(JSON.parseObject(s), String.class);
        log.info("消息者-"+serverPort+"消费消息： "+ message);
        System.err.println("消息者-"+serverPort+"消费消息： "+ message);
    }

}
