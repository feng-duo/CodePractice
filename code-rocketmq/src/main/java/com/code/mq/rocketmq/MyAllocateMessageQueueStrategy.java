package com.code.mq.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义消费队列分配策略
 *
 * @author FengDuo
 * @date 2021/12/12 20:55
 */
@Slf4j
public class MyAllocateMessageQueueStrategy extends AllocateMessageQueueAveragely {

    @Override
    public List<MessageQueue> allocate(String consumerGroup, String currentCID, List<MessageQueue> mqAll, List<String> cidAll) {
        //解析queue id
        int queueId = Integer.parseInt(consumerGroup.substring("MY_CONSUME_GROUP-".length()));
        List<MessageQueue> submq = new ArrayList<>();
        //根据queue id分配相应的MessageQueue
        for(MessageQueue mq : mqAll) {
            if(mq.getQueueId() == queueId ) {
                submq.add(mq);
            }
        }
        if(submq.size() == 0) {
            log.warn("allocate err:"+consumerGroup+","+currentCID+","+cidAll+","+mqAll);
        }
        return super.allocate(consumerGroup, currentCID, submq, cidAll);
    }

    @Override
    public String getName() {
        return "MyAllocate";
    }
}
