package com.code.basic.designpattern.factory;

import org.junit.Test;

/**
 * @author FengDuo
 * @date 2022/6/24 11:10
 */
public class FactoryTest {

    public static void main(String[] args) {
        // simple factory test
        System.out.println(CarFactory.getCar(CarType.FERRARI).description());
        System.out.println(CarFactory.getCar(CarType.FORD).description());
    }


    @Test
    public void PizzaTest(){
        // factory method test
        PizzaStore newYorkPizzaStore = new NewYorkPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        newYorkPizzaStore.orderPizza(PizzaType.NEWYORK_CHEESE.name());
        System.out.println("----------------");
        chicagoPizzaStore.orderPizza(PizzaType.CHICAGO_CHEESE.name());
    }
}
