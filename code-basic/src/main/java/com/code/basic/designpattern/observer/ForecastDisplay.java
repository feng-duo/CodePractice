package com.code.basic.designpattern.observer;

import lombok.Data;

/**
 * @author FengDuo
 * @date 2022/11/3 17:03
 */
@Data
public class ForecastDisplay implements PushObserver, DisplayElement{

    private float pressure;

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }
}
