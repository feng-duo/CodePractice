package com.code.basic.classloader;

import java.lang.reflect.Method;

/**
 * @author FengDuo
 * @date 2022/12/16 17:19
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {
        // 实例化自定义类加载器
        MyClassLoader myClassLoader = new MyClassLoader();
        // 加载当前类
        Class<?> clazz = myClassLoader.findClass("com.code.basic.classloader.ClassLoaderDemo");
        // 通过反射获取实例
        Object instance = clazz.newInstance();
        // 执行指定方法
        Method classLoadTest = instance.getClass().getMethod("classLoadTest");
        classLoadTest.invoke(instance);
    }

    public void classLoadTest() {
        System.out.println("Class load success.");
    }


}
