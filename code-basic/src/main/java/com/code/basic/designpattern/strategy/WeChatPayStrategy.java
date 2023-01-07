package com.code.basic.designpattern.strategy;

/**
 * @author FengDuo
 * @date 2022/8/29 11:27
 */
public class WeChatPayStrategy implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("pay with WeChat Pay.");
    }
}
