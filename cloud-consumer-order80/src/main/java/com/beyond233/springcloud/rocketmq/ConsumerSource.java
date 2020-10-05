package com.beyond233.springcloud.rocketmq;

import org.springframework.messaging.SubscribableChannel;

/**
 * todo
 *
 * @author XuJie
 * @date 2020/8/25 17:31
 */
public interface ConsumerSource {

    String INPUT = "input";

    /**
     *  消费者Source
     * @return org.springframework.messaging.SubscribableChannel
     */
//    @Input(INPUT)
    SubscribableChannel orderConsumer();




}
