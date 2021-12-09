package com.code.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

/**
 * 生产者 - 发送同步消息
 *
 * @author FengDuo
 * @date 2021/12/09 23:11
 */
public class SyncProducer {

    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer = new DefaultMQProducer("TEST_GROUP");
        // 设置NameServer地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动Producer实例
        producer.start();
        for (int i = 0; i < 10; i++) {
            // 创建消息，指定Topic，tag和消息体
            Message message = new Message("TEST_TOPIC", "TAG_A", ("Hello RocketMQ " + i).getBytes(StandardCharsets.UTF_8));
            // 发送消息到中转站Broker
            SendResult sendResult = producer.send(message);
            // 通过sendResult返回消息是否成功送达
            System.out.printf("%s%n", sendResult);
        }
        // 消息发送完毕，关闭Producer实例
        producer.shutdown();
    }
}
