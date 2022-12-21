package com.code.basic.designpattern.factory;

/**
 * @author FengDuo
 * @date 2022/12/21 11:13
 */
public abstract class Pizza {

    public void prepare(){
        System.out.println("Pizza is preparing.");
    }

    public void bake(){
        System.out.println("Pizza is baking.");
    }

    public void cut(){
        System.out.println("Pizza is cutting.");
    }

    public void box(){
        System.out.println("Pizza is boxing.");
    }

}
