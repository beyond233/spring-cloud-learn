package com.beyond233.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-14 22:25
 */
@SpringBootTest
public class TimeTest {
    @Test
    public void test1(){
        System.err.println(ZonedDateTime.now());
    }
}
