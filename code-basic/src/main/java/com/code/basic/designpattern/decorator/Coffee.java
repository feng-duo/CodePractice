package com.code.basic.designpattern.decorator;

import java.math.BigDecimal;

/**
 * 咖啡饮品
 *
 * @author FengDuo
 * @date 2022/11/10 14:58
 */
public class Coffee extends Beverage{

    public Coffee(){
        description = "Coffee";
    }


    @Override
    public BigDecimal cost() {
        return new BigDecimal("1.5");
    }
}
