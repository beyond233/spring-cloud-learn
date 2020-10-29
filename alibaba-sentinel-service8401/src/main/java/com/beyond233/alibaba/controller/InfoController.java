package com.beyond233.alibaba.controller;

import com.beyond233.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 描述: InfoController 控制器类
 *
 * @author beyond233
 * @since 2020/10/11 13:44
 */
@RestController
@RequestMapping("/info")
@Slf4j(topic = "sentinel限流模拟")
public class InfoController {

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        return Result.success(id);
    }

    @GetMapping("/a")
    public Result getInfoA(){
        log.info("request /info/a");
        return Result.success("a");
    }

    @GetMapping("/b")
    public Result getInfoB(){
        log.info("request /info/b");
        return Result.success("b");
    }

    @GetMapping("/rt")
    public Result getInfoRt(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("request /info/rt 降级模拟");
        }
        return Result.success("降级模拟--rt");
    }

    @GetMapping("/error")
    public Result getInfoError(){
        log.info("request /info/error");
        int i = 0 / 0;
        return Result.success("降级模拟--异常比例");
    }

}