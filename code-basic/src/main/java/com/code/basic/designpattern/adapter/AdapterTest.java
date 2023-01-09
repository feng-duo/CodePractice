package com.code.basic.designpattern.adapter;


import org.junit.Test;


/**
 * @author FengDuo
 * @date 2023/1/9 14:38
 */
public class AdapterTest {

    @Test
    public void typeC2HeadphoneJackAdapterTest(){
        TypeC typeC = new TypeC();
        HeadphoneJack headphoneJack = new HeadphoneJack();

        typeC.charge();
        System.out.println("-------------");
        headphoneJack.listen();
        System.out.println("-------------");

        TypeC2HeadphoneJackAdapter adapter = new TypeC2HeadphoneJackAdapter();
        adapter.setTypeCInterface(typeC);
        adapter.listen();
    }
}
