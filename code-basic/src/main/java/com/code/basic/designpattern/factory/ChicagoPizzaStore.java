package com.code.basic.designpattern.factory;

/**
 * @author FengDuo
 * @date 2022/12/21 11:28
 */
public class ChicagoPizzaStore implements PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        return PizzaType.getPizza(type.toUpperCase());
    }
}
