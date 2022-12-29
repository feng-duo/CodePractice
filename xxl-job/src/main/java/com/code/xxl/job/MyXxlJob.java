package com.code.xxl.job;

import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author FengDuo
 * @date 2022/12/29 23:46
 */
@Slf4j
@Component
public class MyXxlJob {

    @XxlJob("MyFirstXxlJob")
    public void MyFirstXxlJob(){
        log.info("Hello xxl-job.");
    }
}
