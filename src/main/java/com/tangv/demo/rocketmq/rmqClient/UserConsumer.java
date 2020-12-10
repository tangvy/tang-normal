package com.tangv.demo.rocketmq.rmqClient;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Description: 消费者
 * Author:      TangWei
 * Date:        2020/8/20 4:21 下午
 */
@Slf4j
@Component
public class UserConsumer {

    @Value("${tangv.rocketmq.consumer.group}")
    private String consumerGroup;

    @Value("${rocketmq.name-server}")
    private String namesrvAddr;

    //@PostConstruct
    public void comsumer(){
        System.err.println("init defaultMQPushConsumer");
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(namesrvAddr);
        try {
            consumer.subscribe("user-topic","user-tag");
            consumer.registerMessageListener((MessageListenerConcurrently) ((list, consumeConcurrentlyContext) -> {
                try {
                    for (MessageExt messageExt : list) {
                        log.info("消费消息：{}", new String(messageExt.getBody()));
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }));
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
