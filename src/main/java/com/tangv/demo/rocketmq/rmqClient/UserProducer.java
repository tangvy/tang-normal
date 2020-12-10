package com.tangv.demo.rocketmq.rmqClient;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Description: 生产者
 * Author:      TangWei
 * Date:        2020/8/19 2:49 下午
 */

@Slf4j
@Component
public class UserProducer {

    @Value("${tangv.rocketmq.producer.group}")
    private String producerGroup;

    @Value("${rocketmq.name-server}")
    private String namesrvAddr;

    //@PostConstruct
    public void producer() {

        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);

        producer.setNamesrvAddr(namesrvAddr);

        try {
            producer.start();
            for (int i = 0;i < 10;i++) {
                producer.setSendMsgTimeout(30000);
                UserContent userContent = new UserContent();
                userContent.setUsername("用户"+String.valueOf(i));
                userContent.setPwd(RandomUtil.randomString(6));
                String JSONString = JSON.toJSONString(userContent);
                Message message = new Message("user-topic","user-tag",JSONString.getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.send(message);
                log.info("发送响应：msgId:{},发送状态：{}",sendResult.getMsgId(),sendResult.getSendStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
