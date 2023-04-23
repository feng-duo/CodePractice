package com.code.basic.transaction.controller;

import com.code.basic.transaction.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FengDuo
 * @date 2023/3/8 11:22
 */
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final AccountService accountService;


    @RequestMapping(value = "/multi_order_transaction", method = RequestMethod.GET)
    public String multiOrderTransaction(){
        return accountService.multiOrderTransaction();
    }

    @RequestMapping(value = "/exception_test", method = RequestMethod.GET)
    public Boolean exceptionTest(){
        if (true) {
            throw new ArithmeticException();
        }
        return Boolean.TRUE;
    }
}
