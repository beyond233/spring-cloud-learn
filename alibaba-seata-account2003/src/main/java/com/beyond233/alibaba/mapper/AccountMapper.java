package com.beyond233.alibaba.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/8 20:46
 */
@Repository
public interface AccountMapper {

    Integer decrease(@Param("userId") String userId,@Param("money") Integer money);
}
