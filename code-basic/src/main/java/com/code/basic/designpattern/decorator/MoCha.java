package com.code.basic.designpattern.decorator;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 摩卡
 *
 * @author FengDuo
 * @date 2022/11/10 15:05
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MoCha extends CondimentDecorator {

    private Beverage beverage;

    public MoCha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal("0.5").add(beverage.cost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", MoCha";
    }
}
