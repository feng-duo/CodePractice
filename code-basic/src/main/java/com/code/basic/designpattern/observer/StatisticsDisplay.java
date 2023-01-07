package com.code.basic.designpattern.observer;

import lombok.Data;

/**
 * @author FengDuo
 * @date 2022/11/3 17:02
 */
@Data
public class StatisticsDisplay implements PushObserver, DisplayElement{

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
