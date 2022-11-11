package com.code.basic.designpattern.decorator;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author FengDuo
 * @date 2022/11/10 15:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Milk extends CondimentDecorator {

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("2.0").add(beverage.cost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
