package com.code.basic.designpattern.singleton;

/**
 * 单例模式
 *
 * @author FengDuo
 * @date 2021/12/08 23:13
 */
public class SingleInstance {
    private static final SingleInstance instance = new SingleInstance();

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        return instance;
    }
}


/**
 * 懒汉式
 */
class LHan {
    private static LHan lHan;

    private LHan() {
    }

    public static synchronized LHan getInstance() {
        if (lHan == null) {
            lHan = new LHan();
        }
        return lHan;
    }
}

/**
 * 双检锁
 */
class DoubleCheck {
    private static DoubleCheck check;

    private DoubleCheck() {
    }

    public static DoubleCheck getInstance() {
        if (check == null) {
            synchronized (DoubleCheck.class) {
                if (check == null) {
                    check = new DoubleCheck();
                }
            }
        }
        return check;
    }
}

/**
 * 静态内部类
 */
class Singleton {
    private static class SingletonHolder {
        private static final Singleton SINGLETON = new Singleton();
    }

    private Singleton() {
    }


    public static Singleton getInstance() {
        return SingletonHolder.SINGLETON;
    }
}

/**
 * 枚举
 */
enum SingletonEnum {
    INSTANCE;

    public void getInstance() {

    }
}

