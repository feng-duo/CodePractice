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

    /**
     * 服务端通过docker部署在华为云上，内网执行器无法执行任务，需要内网穿透
     */
    @XxlJob("MyFirstXxlJob")
    public void MyFirstXxlJob(){
        System.out.println("------------------");
        log.info("Hello xxl-job.");
    }
}
