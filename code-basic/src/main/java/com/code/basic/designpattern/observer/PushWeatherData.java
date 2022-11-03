package com.code.basic.designpattern.observer;

import lombok.Data;

import java.util.ArrayList;

/**
 * 天气主题
 *
 * @author FengDuo
 * @date 2022/11/3 16:19
 */
@Data
public class PushWeatherData implements PushSubject {

    private float temperature;
    private float humidity;
    private float pressure;

    private ArrayList<PushObserver> pushObserverList;

    public PushWeatherData() {
        pushObserverList = new ArrayList<>();
    }

    @Override
    public void registerObserver(PushObserver pushObserver) {
        pushObserverList.add(pushObserver);
    }

    @Override
    public void removeObserver(PushObserver pushObserver) {
        pushObserverList.remove(pushObserver);
    }

    @Override
    public void notifyObserver() {
        for (PushObserver pushObserver : pushObserverList) {
            pushObserver.update(temperature, humidity, pressure);
        }
    }

    public void setData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }
}
