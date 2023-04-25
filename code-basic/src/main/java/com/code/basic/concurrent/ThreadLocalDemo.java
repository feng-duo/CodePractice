package com.code.basic.concurrent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author FengDuo
 * @date 2023/03/16 22:10
 */
@Slf4j
public class ThreadLocalDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Person person = new Person("jack", 1);
        log.info("init:{}", person);
        new Thread(() -> {
            ThreadLocal<Person> threadLocal = new ThreadLocal<>();
            threadLocal.set(new Person(person.getName(), person.getSex()));
            log.info("threadID:{}, before update:{}", Thread.currentThread().getId(), threadLocal.get());
            threadLocal.get().setName("john");
            log.info("threadID:{}, after update:{}", Thread.currentThread().getId(), threadLocal.get());
            threadLocal.remove();
        }).start();

        new Thread(() -> {
            ThreadLocal<Person> threadLocal = new ThreadLocal<>();
            threadLocal.set(new Person(person.getName(), person.getSex()));
            log.info("threadID:{}, before update:{}", Thread.currentThread().getId(), threadLocal.get());
            threadLocal.get().setName("windy");
            log.info("threadID:{}, after update:{}", Thread.currentThread().getId(), threadLocal.get());
            threadLocal.remove();
        }).start();
        log.info("end:{}", person);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person {
        private String name;
        private Integer sex;
    }
}
