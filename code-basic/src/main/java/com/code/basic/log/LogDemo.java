package com.code.basic.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author FengDuo
 * @date 2023/1/11 10:50
 */
@Slf4j
@Component
public class LogDemo implements InitializingBean {

    @Test
    public void logTest() {
        // https://www.cnblogs.com/simpleito/p/15133654.html
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
