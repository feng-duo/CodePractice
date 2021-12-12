package com.code.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.CountDownLatch2;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * 生产者 - 发送异步消息
 *
 * @author FengDuo
 * @date 2021/12/11 19:32
 */
@Slf4j
public class AsyncProducer {

    public static void main(String[] args) throws Exception {
        // 实例化生产者
        DefaultMQProducer producer = new DefaultMQProducer("ASYNC_GROUP");
        // 设置NameServer地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动实例
        producer.start();
        // 发送失败重试次数为0
        producer.setRetryTimesWhenSendAsyncFailed(0);
        int msgCount = 10;
        final CountDownLatch2 countDownLatch = new CountDownLatch2(msgCount);
        for (int i = 0; i < msgCount; i++) {
            final int index = i;
            // 创建消息，并指定Topic，Tag和消息体
            Message message = new Message("TEST_TOPIC", "TAG_B", ("异步消息：" + i).getBytes(StandardCharsets.UTF_8));
            // SendCallback接收异步返回结果的回调
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    countDownLatch.countDown();
                    System.out.printf("%-10d OK %s %n", index, sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    countDownLatch.countDown();
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        // 等待5s
        countDownLatch.await(5, TimeUnit.SECONDS);
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
    }

}
