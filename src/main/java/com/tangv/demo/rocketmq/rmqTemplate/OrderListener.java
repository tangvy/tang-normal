package com.tangv.demo.rocketmq.rmqTemplate;

import com.tangv.demo.model.OrderDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/9/24 4:08 下午
 */

@RocketMQMessageListener(topic = "template-order-topic",consumerGroup = "order-template-consumer-group",messageModel = MessageModel.CLUSTERING,consumeMode = ConsumeMode.ORDERLY)
@Component
@Slf4j
public class OrderListener implements RocketMQListener<OrderDO> {
    @Override
    public void onMessage(OrderDO orderDO) {
        log.info("收到消息:{} {}",orderDO.getOrderId(),orderDO.getDesc());
    }
}
