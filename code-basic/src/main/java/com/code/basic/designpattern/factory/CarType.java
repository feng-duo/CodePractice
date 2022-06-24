package com.code.basic.designpattern.factory;


import lombok.Getter;

import java.util.function.Supplier;

/**
 * @author FengDuo
 * @date 2022/6/24 11:02
 */
@Getter
public enum CarType {

    FERRARI(Ferrari::new),
    FORD(Ford::new);

    private final Supplier<Car> constructor;

    CarType(Supplier<Car> constructor) {
        this.constructor = constructor;
    }
}
