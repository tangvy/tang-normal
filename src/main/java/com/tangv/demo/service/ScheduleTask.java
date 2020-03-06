package com.tangv.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/2/29 7:21 下午
 */
@Component
public class ScheduleTask {

    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    public void process(){
        //System.out.println("this is schedule task running"+(count++));
    }

}
