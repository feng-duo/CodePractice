package com.code.basic.designpattern.simplefactory;

/**
 * @author FengDuo
 * @date 2022/6/24 11:10
 */
public class FactoryTest {

    public static void main(String[] args) {
        System.out.println(CarFactory.getCar(CarType.FERRARI).description());
        System.out.println(CarFactory.getCar(CarType.FORD).description());
    }
}
