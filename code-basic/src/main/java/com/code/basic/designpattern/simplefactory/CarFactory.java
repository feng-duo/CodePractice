package com.code.basic.designpattern.simplefactory;

/**
 * @author FengDuo
 * @date 2022/6/24 11:00
 */
public class CarFactory {

    public static Car getCar(CarType carType){
        return carType.getConstructor().get();
    }
}
