package com.code.xxl.job;

import com.code.xxl.job.config.XxlJobConfig;
import com.code.xxl.job.model.XxlJobInfo;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 通过接口动态配置调度任务
 *
 * @author FengDuo
 * @date 2023/01/07 23:37
 */
@RestController
@RequestMapping("/job")
public class XxlJobController {

    @Autowired
    private XxlJobConfig xxlJobConfig;


    private static final String ADD_URL = "/jobinfo/add";
    private static final String UPDATE_URL = "/jobinfo/update";
    private static final String REMOVE_URL = "/jobinfo/remove";
    private static final String PAUSE_URL = "/jobinfo/pause";
    private static final String START_URL = "/jobinfo/start";
    private static final String ADD_START_URL = "/jobinfo/addAndStart";
    private static final String GET_GROUP_ID = "/jobgroup/getGroupId";


    @RequestMapping("/add_job")
    public ResponseEntity addJob(@RequestBody XxlJobInfo xxlJobInfo) throws IOException {
        xxlJobInfo.setJobGroup(1);
        xxlJobInfo.setJobDesc("这是描述");
        xxlJobInfo.setAuthor("fengduo");
        xxlJobInfo.setScheduleType("CRON");
        xxlJobInfo.setScheduleConf("0 0 * * * ? *");
        xxlJobInfo.setGlueType("BEAN");
        xxlJobInfo.setExecutorHandler("testJobHandler");
        xxlJobInfo.setExecutorRouteStrategy("ROUND");
        xxlJobInfo.setMisfireStrategy("DO_NOTHING");
        xxlJobInfo.setExecutorBlockStrategy("SERIAL_EXECUTION");
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(xxlJobConfig.getAdminAddresses() + ADD_URL)
                .post(okhttp3.RequestBody.create(new Gson().toJson(xxlJobInfo), MediaType.parse("application/json; charset=utf-8")))
                .build();
        Call call = okHttpClient.newCall(request);
        call.timeout().timeout(30L, TimeUnit.SECONDS);
        Response response = call.execute();
        System.out.println(response.body().string());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
