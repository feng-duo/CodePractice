package com.code.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 生产者 - 单向发送消息
 * <p>
 * 这种方式主要用在不特别关心发送结果的场景，例如日志发送
 *
 * @author FengDuo
 * @date 2021/12/11 19:43
 */
public class OnewayProducer {

    public static void main(String[] args) throws Exception {
        // 实例化生产者
        DefaultMQProducer producer = new DefaultMQProducer("ONEWAY_GROUP");
        // 设置NameServer地址
        producer.setNamesrvAddr("localhost:9876");
        // 启动实例
        producer.start();
        for (int i = 0; i < 10; i++) {
            // 创建消息，并指定Topic，Tag和消息体
            Message message = new Message("TEST_TOPIC", "TAG_C", ("单向发送消息：" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送消息到一个Broker
            SendResult sendResult = producer.send(message);
            // 通过sendResult返回消息是否成功送达
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();
    }

}
