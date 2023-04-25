package com.code.basic.designpattern.adapter;

/**
 * @author FengDuo
 * @date 2023/1/9 15:42
 */
public class HeadphoneJack implements HeadphoneJackInterface{

    @Override
    public void listen() {
        System.out.println("listening by HeadphoneJack.");
    }
}
