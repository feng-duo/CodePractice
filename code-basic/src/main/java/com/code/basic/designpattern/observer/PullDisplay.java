package com.code.basic.designpattern.observer;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @author FengDuo
 * @date 2022/11/7 10:35
 */
@Data
public class PullDisplay implements Observer, DisplayElement {

    private float temperature;
    private float pressure;
    private Observable observable;

    public PullDisplay (Observable observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof PullWeatherData) {
            if (o.hasChanged()) {
                setPressure(((PullWeatherData) o).getPressure());
                setTemperature(((PullWeatherData) o).getTemperature());
                display();
            }
        }
    }

    @Override
    public void display() {
        System.out.println("temperature=" + this.getPressure() + ", temperature=" + this.getTemperature());
    }
}
