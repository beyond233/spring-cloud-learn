package com.beyond233.alibaba.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/8 21:34
 */
@Repository
public interface StorageMapper {

    Integer decrease(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
