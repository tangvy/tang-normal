package com.tangv.demo.rocketmq.rmqTemplate;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Random;

/**
 * Description: 生产者
 * Author:      TangWei
 * Date:        2020/8/14 3:42 下午
 */
@Slf4j
@Component
public class Producer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void testRocketString() {
        String name = "发送rocket消息！";
        rocketMQTemplate.convertAndSend("test-topic-1",name);
        log.info("test-topic-1发送成功");
        rocketMQTemplate.send("test-topic-2", MessageBuilder.withPayload(new OrderPaidEvent("消息ID1",new BigDecimal("34.33"))).build());
        log.info("test-topic-2发送成功");
        for (int i = 0;i < 20;i++) {
            OrderPaidEvent event = new OrderPaidEvent(Integer.toString(i),BigDecimal.valueOf(RandomUtil.randomLong()));
            rocketMQTemplate.asyncSend("test-topic-2", event, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("成功发送消息");
                }

                @Override
                public void onException(Throwable throwable) {
                    log.info("消息发送失败",throwable.getMessage());
                }
            });
        }
    }

}
