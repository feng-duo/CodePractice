package com.code.basic.designpattern.factory;

/**
 * @author FengDuo
 * @date 2022/12/21 11:30
 */
public class ChicagoCheesePizza extends Pizza{

    @Override
    public void prepare() {
        System.out.print("Chicago Cheese ");
        super.prepare();
    }

    @Override
    public void bake() {
        System.out.print("Chicago Cheese ");
        super.bake();
    }

    @Override
    public void cut() {
        System.out.print("Chicago Cheese ");
        super.cut();
    }

    @Override
    public void box() {
        System.out.print("Chicago Cheese ");
        super.box();
    }
}
