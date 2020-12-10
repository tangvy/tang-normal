package com.tangv.demo.model;

import lombok.Data;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/9/24 9:56 上午
 */

@Data
public class OrderDO {

    private String orderId;

    private String desc;

    public OrderDO(String orderId, String desc) {
        this.orderId = orderId;
        this.desc = desc;
    }
}
