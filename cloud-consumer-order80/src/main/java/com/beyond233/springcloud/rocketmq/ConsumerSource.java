package com.beyond233.springcloud.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * todo
 *
 * @author XuJie
 * @date 2020/8/25 17:31
 */
public interface ConsumerSource {

    String INPUT = "order80-consumer";

    /**
     *  消费者Source
     * @return org.springframework.messaging.SubscribableChannel
     */
    @Input(INPUT)
    SubscribableChannel orderConsumer();




}
