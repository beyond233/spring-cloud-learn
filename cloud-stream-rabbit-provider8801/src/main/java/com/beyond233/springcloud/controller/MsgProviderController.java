package com.beyond233.springcloud.controller;

import com.beyond233.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>项目文档: </p>
 *
 * @author beyond233
 * @version 1.0
 * @since 2020-09-20 17:00
 */
@RestController
public class MsgProviderController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String sendMsg(){
        return messageProvider.send();
    }
}
