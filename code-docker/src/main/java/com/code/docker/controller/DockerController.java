package com.code.docker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FengDuo
 * @date 2024/06/05 17:20
 */
@Slf4j
@RestController
@RequestMapping("/docker")
public class DockerController {


    @RequestMapping(method = RequestMethod.GET, value = "/method")
    public String dockerMethod (@RequestParam(required = false) String param) {
        log.info("catch request, params :{}", param);
        return "Hello, Docker.";
    }
}
