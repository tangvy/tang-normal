package com.tangv.demo.rocketmq.rmqTemplate;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/8/14 5:36 下午
 */

@Slf4j
@Service
@RocketMQMessageListener(topic = "test-topic-2",consumerGroup = "my-consumer-test-topic-2")
public class OrderPaidEventComsumer implements RocketMQListener<OrderPaidEvent> {
    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        log.info("收到消息--------{}:{}",orderPaidEvent.getOrderId(),orderPaidEvent.getPaidMoney());
    }
}
