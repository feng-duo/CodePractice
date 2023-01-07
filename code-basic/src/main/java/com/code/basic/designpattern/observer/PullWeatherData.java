package com.code.basic.designpattern.observer;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Observable;

/**
 * 继承jdk自带的Observable实现观察者模式
 *
 * @author FengDuo
 * @date 2022/11/7 10:30
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PullWeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public void setData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        super.setChanged();
    }



}
