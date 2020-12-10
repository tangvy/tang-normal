package com.tangv.demo.rocketmq.rmqTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/8/14 5:27 下午
 */
@Data
public class OrderPaidEvent implements Serializable {

    private String orderId;

    private BigDecimal paidMoney;

    public OrderPaidEvent(String orderId, BigDecimal paidMoney) {
        this.orderId = orderId;
        this.paidMoney = paidMoney;
    }
}
