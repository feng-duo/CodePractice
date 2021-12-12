package com.code.rocketmq;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.selector.SelectMessageQueueByHash;
import org.apache.rocketmq.common.CountDownLatch2;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * 通过指定消息队列发送消息
 *
 * @author FengDuo
 * @date 2021/12/12 16:42
 */
@Slf4j
public class MyProducer {

    public static void main(String[] args)  throws Exception{
        // 实例化生产者
        DefaultMQProducer producer = new DefaultMQProducer("MY_GROUP");
        // 设置NameServer地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动实例
        producer.start();
        // 发送失败重试次数为0
        int  msgCount = 10;
        final CountDownLatch2 countDownLatch = new CountDownLatch2(msgCount);
        for (int i = 0; i < msgCount; i++) {
            final int index = i;
            // 创建消息，并指定Topic，Tag和消息体
            Message message = new Message("TEST_TOPIC", "TAG_MY", ("发送指定消息队列：" + i).getBytes(StandardCharsets.UTF_8));
            // SendCallback接收异步返回结果的回调
            // 根据index将msg通过hash放到指定消息队列
            producer.send(message, new SelectMessageQueueByHash(), index, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    countDownLatch.countDown();
                    log.info("index：{}, 消息ID：{}, 消息结果：{}", index, sendResult.getMsgId(), sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    countDownLatch.countDown();
                    log.warn("异常：{}", e.getMessage());
                    // 写入数据库或者写入文件
                }
                // 设置超时时间为1ms，进入重试
            });
        }
        // 等待5s
        countDownLatch.await(5, TimeUnit.SECONDS);
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }
}
