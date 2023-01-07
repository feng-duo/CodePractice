package com.code.basic.designpattern.strategy;

/**
 * 策略模式测试
 *
 * @author FengDuo
 * @date 2022/8/29 11:31
 */
public class StrategyTest {

    public static void main(String[] args) {
        Order order = new Order();
        order.setPayment(new AlipayStrategy());
        order.payWithOrder();
        System.out.println("----------------change payment---------------");
        order.setPayment(new WeChatPayStrategy());
        order.payWithOrder();
    }
}
