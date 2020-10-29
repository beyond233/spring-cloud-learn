package com.beyond233.alibaba.mapper;

import com.beyond233.alibaba.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 描述: 订单DAO
 *   通过继承 JpaRepository<T,ID>实现订单dao:  T-实体类; ID-实体类主键类型
 *
 * @author beyond233
 * @since 2020/10/8 17:51
 */
@Repository
public interface OrderMapper {

    /**
     * 创建订单
     *
     * @param order
     * @return  {@link Integer}
     * @author beyond233
     * @since 2020/10/8 20:03
     */
    Integer create(@Param("order") Order order);

    /**
     * 修改订单状态
     *
     * @param id  id
     * @param status 状态
     * @return  {@link Integer}
     * @author beyond233
     * @since 2020/10/8 20:03
     */
    Integer updateOrder(@Param("id") Integer id, @Param("status") Integer status);
}
