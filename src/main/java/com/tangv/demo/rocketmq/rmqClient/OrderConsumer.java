package com.tangv.demo.rocketmq.rmqClient;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description: 消费者
 * Author:      TangWei
 * Date:        2020/8/20 4:21 下午
 */
@Slf4j
@Component
public class OrderConsumer {

    @Value("${tangv.rocketmq.consumer.order.group}")
    private String consumerGroup;

    @Value("${rocketmq.name-server}")
    private String namesrvAddr;

    @PostConstruct
    public void orderComsumer(){
        log.info("消费者初始化...");
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(namesrvAddr);
        try {
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.subscribe("order-topic","tagA||tagC||tagD");
            consumer.registerMessageListener(new MessageListenerOrderly() {
                Random random = new Random();
                @Override
                public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                    consumeOrderlyContext.setAutoCommit(true);
                    for (MessageExt msg : list) {
                        log.info("{} 收到新消息：{},content:{}",Thread.currentThread().getName(),msg.getMsgId(),new String(msg.getBody()));
                    }
                    try {
                        TimeUnit.SECONDS.sleep(random.nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return ConsumeOrderlyStatus.SUCCESS;
                }
            });
            consumer.start();
            log.info("消费者启动...");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
