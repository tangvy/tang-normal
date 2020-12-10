package com.tangv.demo.controller;

import com.tangv.demo.rocketmq.rmqClient.OrderProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/9/24 3:14 下午
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/client/sendMsg")
    public String sendClientMsg() throws RemotingException, InterruptedException, MQBrokerException {
        orderProducer.produceClientOrder();
        return "success";
    }

    @PostMapping("/template/sendMsg")
    public String sendTemplateMsg() throws RemotingException, InterruptedException, MQBrokerException {
        orderProducer.produceTemplateOrder();
        return "success";
    }

}
