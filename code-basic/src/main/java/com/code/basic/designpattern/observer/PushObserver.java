package com.code.basic.designpattern.observer;

/**
 * observer receive message with push
 *
 * @author FengDuo
 * @date 2022/11/3 16:15
 */
public interface PushObserver{

    void update(float temperature, float humidity, float pressure);
}
