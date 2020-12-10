package com.tangv.demo.rocketmq.rmqClient;

import com.tangv.demo.model.OrderDO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/9/23 4:07 下午
 */

@Slf4j
@Component
public class OrderProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Value("${tangv.rocketmq.producer.order.group}")
    private String producerGroup;

    @Value("${rocketmq.name-server}")
    private String namesrvAddr;

    public void produceClientOrder() throws RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(namesrvAddr);
        try {
            producer.start();
            producer.setSendMsgTimeout(30000);
            String[] tags = new String[]{"tagA","tagC","tagD"};
            List<OrderDO> orderList = this.buildOrders();
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String currentTimeStr = dateTimeFormatter.format(currentTime);
            for (int i = 0;i<orderList.size();i++) {
                String body = currentTimeStr + " ROCKETMQ MESSAGE " + orderList.get(i).getOrderId() + orderList.get(i).getDesc();
                Message message = new Message("order-topic",tags[i%tags.length],"KEY"+i,body.getBytes());
                SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                        long orderId = Long.parseLong((String) o);
                        long index = orderId % list.size();
                        return list.get((int) index);
                    }
                }, orderList.get(i).getOrderId());//通过订单ID获取对应的queue
                log.info("{},body:{}",sendResult,body);
            }
            producer.shutdown();

        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public void produceTemplateOrder() {
        rocketMQTemplate.setMessageQueueSelector(new MessageQueueSelector() {
            @Override
            public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                long orderId = Long.parseLong((String) o);
                long index = orderId % list.size();
                return list.get((int)index);
            }
        });
        List<OrderDO> orders = this.buildOrders();
        for (int i=0;i<orders.size();i++) {
            rocketMQTemplate.syncSendOrderly("template-order-topic",orders.get(i),orders.get(i).getOrderId());
            log.info("发送第{}条消息：{}",i,orders.get(i).getOrderId());
        }
    }

    /*
    * 生成模拟订单数据
    * */
    private List<OrderDO> buildOrders() {

        List<OrderDO> orderList = new ArrayList<>();

        orderList.add(new OrderDO("15103111039","创建"));
        orderList.add(new OrderDO("15103111065","创建"));
        orderList.add(new OrderDO("15103111039","付款"));
        orderList.add(new OrderDO("15103117235","创建"));
        orderList.add(new OrderDO("15103111065","付款"));
        orderList.add(new OrderDO("15103117235","付款"));
        orderList.add(new OrderDO("15103111065","完成"));
        orderList.add(new OrderDO("15103111039","推送"));
        orderList.add(new OrderDO("15103117235","完成"));
        orderList.add(new OrderDO("15103111039","完成"));

        return orderList;
    }


}
