package com.beyond233.springcloud.mapper;

import com.beyond233.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-06-06 18:50
 */
@Repository
public interface PaymentMapper {
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
