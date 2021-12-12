package com.code.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 消费者 - 指定线程消费
 *
 * @author FengDuo
 * @date 2021/12/09 23:12
 */
@Slf4j
public class SecondConsumer {

    public static void main(String[] args) throws Exception {
        // 实例化消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("MY_CONSUME_GROUP-1");
        // 设置NameServer地址
        consumer.setNamesrvAddr("localhost:9876");
        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe("TEST_TOPIC", "TAG_MY");
//        consumer.setAllocateMessageQueueStrategy(new MyAllocateMessageQueueStrategy());
        // 设置消费者线程数
        consumer.setConsumeThreadMin(5);
        consumer.setConsumeThreadMax(5);
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgList, ConsumeConcurrentlyContext context) {
                for (MessageExt message : msgList) {
                    log.info("UNIQ_KEY：{}, queueOffset:{}, queueId:{}", message.getProperty("UNIQ_KEY"), message.getQueueOffset(), message.getQueueId());
                }
                // 标记该消息已经被成功消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("Consumer Started.");
    }
}
