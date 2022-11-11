package com.code.basic.designpattern.decorator;

import java.math.BigDecimal;

/**
 * 饮品抽象类
 *
 * @author FengDuo
 * @date 2022/11/10 14:53
 */
public abstract class Beverage {

    public String description = "Unknown Beverage.";

    public String getDescription() {
        return description;
    }

    public abstract BigDecimal cost();
}
