package com.code.basic.designpattern.observer;

/**
 * 观察者模式测试
 *
 * @author FengDuo
 * @date 2022/11/3 17:03
 */
public class ObserverTest {

    public static void main(String[] args) {
        // push方式获取数据
        PushWeatherData pushWeatherData = new PushWeatherData();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        pushWeatherData.registerObserver(statisticsDisplay);
        pushWeatherData.registerObserver(forecastDisplay);

        pushWeatherData.setData(1.2F, 2F, 5F);
        pushWeatherData.setData(1.5F, 6F, 3F);

        System.out.println("--------------------------");

        // pull方式获取数据
        PullWeatherData pullWeatherData = new PullWeatherData();
        pullWeatherData.setData(1.5F, 6F, 3F);
        PullDisplay pullDisplay = new PullDisplay(pullWeatherData);
        pullDisplay.update(pullWeatherData, null);
        System.out.println("----------------------------");
        pullDisplay.update(pullWeatherData, null);

        pullWeatherData.setData(2F, 6F, 3F);
        pullDisplay.update(pullWeatherData, null);

    }
}
