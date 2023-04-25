package com.code.basic.designpattern.adapter;

/**
 * @author FengDuo
 * @date 2023/1/9 15:41
 */
public class TypeC implements TypeCInterface{

    @Override
    public void charge() {
        System.out.println("charging by TypeC.");
    }
}
