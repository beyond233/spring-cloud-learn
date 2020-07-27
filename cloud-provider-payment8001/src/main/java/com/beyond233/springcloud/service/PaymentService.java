package com.beyond233.springcloud.service;

import com.beyond233.springcloud.entity.Payment;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 20:49
 */
public interface PaymentService {
    /**
     * 添加
     * @param payment
     * @return int
     * @since 2020/6/6 18:51
     */
    int add(Payment payment);

    /**
     * 通过id获取payment
     * @param id
     * @return com.beyond233.springcloud.entity.Payment
     * @since 2020/6/6 18:51
     */
    Payment getPaymentById(Long id);
}
