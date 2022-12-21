package com.code.basic.designpattern.factory;

/**
 * @author FengDuo
 * @date 2022/12/21 11:14
 */
public interface PizzaStore {

    default Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    Pizza createPizza(String type);
}
