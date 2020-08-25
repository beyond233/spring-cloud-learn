package com.beyond233.springcloud.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * todo
 *
 * @author XuJie
 * @date 2020/8/25 17:31
 */
public interface ConsumerSource {

    /**
     * @return org.springframework.messaging.SubscribableChannel
     * @description 消费者Source
     */
    @Input("order80-consumer")
    SubscribableChannel orderConsumer();

}
