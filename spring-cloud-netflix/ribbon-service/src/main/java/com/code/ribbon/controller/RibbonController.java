package com.code.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon load balance test controller
 *
 * @author FengDuo
 * @date 2023/02/15 22:02
 */
@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    //面向微服务编程，即通过微服务的名称来获取调用地址
    //使用注册到 Spring Cloud Eureka 服务注册中心中的服务，即 application.name
    private static final String REST_URL_PROVIDER_PREFIX = "http://eureka-client-producer";

    @RequestMapping(value = "/check",method = RequestMethod.GET)
    public String check() {
        // 这里调用的是client模块EurekaclientApplication中的check请求路径
        // 需要注意的是EUREKA-CLIENT是server中加载的客户端名字，默认全部大写
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/method", String.class);
    }

}
