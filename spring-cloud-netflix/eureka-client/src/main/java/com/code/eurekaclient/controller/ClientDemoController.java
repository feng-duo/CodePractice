package com.code.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FengDuo
 * @date 2023/2/9 14:09
 */
@RestController
public class ClientDemoController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/method")
    public String method(){
        return "request success." + port;
    }
}
