package com.code.basic.designpattern.factory;

/**
 * @author FengDuo
 * @date 2022/12/21 11:30
 */
public class NewYorkCheesePizza extends Pizza{

    @Override
    public void prepare() {
        System.out.print("NewYork Cheese ");
        super.prepare();
    }

    @Override
    public void bake() {
        System.out.print("NewYork Cheese ");
        super.bake();
    }

    @Override
    public void cut() {
        System.out.print("NewYork Cheese ");
        super.cut();
    }

    @Override
    public void box() {
        System.out.print("NewYork Cheese ");
        super.box();
    }
}
