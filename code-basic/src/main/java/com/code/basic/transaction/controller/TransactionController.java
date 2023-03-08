package com.code.basic.transaction.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FengDuo
 * @date 2023/3/8 11:22
 */
@RestController
public class TransactionController {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){

        return "success";
    }
}
