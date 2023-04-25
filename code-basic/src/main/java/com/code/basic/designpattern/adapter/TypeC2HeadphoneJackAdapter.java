package com.code.basic.designpattern.adapter;

import lombok.Data;

/**
 * type-c转3.5mm接口适配器
 *
 * @author FengDuo
 * @date 2023/1/9 15:44
 */
@Data
public class TypeC2HeadphoneJackAdapter implements HeadphoneJackInterface{

    private TypeCInterface typeCInterface;

    @Override
    public void listen() {
        typeCInterface.charge();
        System.out.println("Listening by TypeC too.");
    }
}
