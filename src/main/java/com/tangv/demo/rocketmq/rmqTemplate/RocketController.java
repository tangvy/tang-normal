package com.tangv.demo.rocketmq.rmqTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/8/17 10:11 上午
 */

@RestController
public class RocketController {

    @Autowired
    private Producer producer;

    @PostMapping("/rocket")
    public String test() {
        producer.testRocketString();
        return "success";
    }
}
