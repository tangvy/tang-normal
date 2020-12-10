package com.tangv.demo.controller;

import com.tangv.demo.dao.DataMapper;
import com.tangv.demo.model.Data;
import com.tangv.demo.repository.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/8/10 2:52 下午
 */

@RestController
@Slf4j
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private DataMapper dataMapper;

    /*@Autowired
    */private DataSourceTransactionManager transactionManager;

    @PostMapping("/insertData")
    public String insertData() {
            Data data = new Data();
            data.setData("测试新增修改aop");
            dataMapper.insert(data);
            //log.info("成功插入第{}条数据",i);
        return "success";
    }

    @PostMapping("/getData")
    @Transactional(rollbackFor = Exception.class)
    public Data getData(@RequestParam Long id) {
        Data data = dataMapper.selectByPrimaryKey(id);
        return data;
        /*DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Data data = dataRepository.findById(id).orElse(null);
            System.out.println("修改前：" + data.getData());
            data.setData("新的内容");
            dataRepository.save(data);
            Data data1 = dataRepository.findById(id).orElse(null);
            System.out.println("修改后：" + data1.getData());
            transactionManager.commit(status);
        }catch (Exception e) {
            transactionManager.rollback(status);
        }*/
    }
}
