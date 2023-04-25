package com.code.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class BasicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicWebApplication.class, args);
    }

}
