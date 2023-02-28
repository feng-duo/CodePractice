package com.code.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FengDuo
 * @date 2023/2/9 14:09
 */
@RestController
@RequestMapping("/request")
public class ClientDemoController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/get_method")
    public String method(){
        return "get request success." + port;
    }

    @PostMapping("/post_method")
    public String postMethod(){
        return "post request success." + port;
    }
}
