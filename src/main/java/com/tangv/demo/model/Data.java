package com.tangv.demo.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Description: 数据表
 * Author:      TangWei
 * Date:        2020/8/10 2:24 下午
 */
@Entity
@lombok.Data
public class Data extends BasePojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime gmtCreate;

    @LastModifiedDate
    private LocalDateTime gmtModify;

    private String data;

}
