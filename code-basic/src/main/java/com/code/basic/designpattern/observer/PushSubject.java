package com.code.basic.designpattern.observer;

/**
 *
 * @author FengDuo
 * @date 2022/11/3 16:47
 */
public interface PushSubject {

    void registerObserver(PushObserver pushObserver);

    void removeObserver(PushObserver pushObserver);

    void notifyObserver();
}
