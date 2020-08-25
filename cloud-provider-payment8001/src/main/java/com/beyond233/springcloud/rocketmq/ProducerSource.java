package com.beyond233.springcloud.rocketmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-08-25 22:03
 */
public interface ProducerSource {

    String OUTPUT = "provider-payment8001-producer";

    /**
     * 生产者Source
     * @return org.springframework.messaging.MessageChannel
     */
    @Output(ProducerSource.OUTPUT)
    MessageChannel paymentProducer();
}
