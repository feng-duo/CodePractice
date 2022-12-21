package com.code.basic.designpattern.factory;

/**
 * @author FengDuo
 * @date 2022/12/21 11:29
 */
public class NewYorkPizzaStore implements PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        return PizzaType.getPizza(type);
    }
}
