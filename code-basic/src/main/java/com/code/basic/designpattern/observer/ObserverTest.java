package com.code.basic.designpattern.observer;

/**
 * 观察者模式测试
 *
 * @author FengDuo
 * @date 2022/11/3 17:03
 */
public class ObserverTest {

    public static void main(String[] args) {
        PushWeatherData pushWeatherData = new PushWeatherData();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        pushWeatherData.registerObserver(statisticsDisplay);
        pushWeatherData.registerObserver(forecastDisplay);

        pushWeatherData.setData(1.2F, 2F, 5F);
        pushWeatherData.setData(1.5F, 6F, 3F);
    }
}
