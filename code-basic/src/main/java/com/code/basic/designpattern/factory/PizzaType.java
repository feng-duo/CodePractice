package com.code.basic.designpattern.factory;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author FengDuo
 * @date 2022/12/21 11:21
 */
@Getter
public enum PizzaType {

    CHICAGO_CHEESE("CHICAGO_CHEESE", ChicagoCheesePizza::new),
    NEWYORK_CHEESE("NEWYORK_CHEESE", NewYorkCheesePizza::new);

    private final String type;
    private final Supplier<Pizza> supplier;

    PizzaType(String type, Supplier<Pizza> supplier) {
        this.type = type;
        this.supplier = supplier;
    }

    public static Pizza getPizza(String type) {
        Supplier<Pizza> pizzaSupplier = Arrays.stream(PizzaType.values())
                .filter(pizzaType -> StringUtils.equals(pizzaType.getType(), type))
                .map(PizzaType::getSupplier)
                .findFirst()
                .orElse(null);
        return null == pizzaSupplier ? null : pizzaSupplier.get();
    }
}
