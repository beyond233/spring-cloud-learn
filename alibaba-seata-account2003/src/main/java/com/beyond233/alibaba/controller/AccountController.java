package com.beyond233.alibaba.controller;

import com.beyond233.alibaba.mapper.AccountMapper;
import com.beyond233.springcloud.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 *
 * @author beyond233
 * @since 2020/10/8 21:12
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountMapper accountMapper;

    @PostMapping("/decrease")
    public Result decrease(@RequestParam("userId") String userId, @RequestParam("money") Integer money) {
        Integer result = accountMapper.decrease(userId, money);
        return result == 1 ? Result.success(1) : Result.fail(0);
    }
}
