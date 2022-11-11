package com.code.basic.designpattern.decorator;

/**
 * @author FengDuo
 * @date 2022/11/10 15:17
 */
public class DecoratorTest {

    public static void main(String[] args) {
        // 点一杯咖啡
        Beverage coffee = new Coffee();
        // 加摩卡
        coffee = new MoCha(coffee);
        // 加牛奶
        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription());
        System.out.println(coffee.cost());
    }
}
