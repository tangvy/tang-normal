package com.tangv.demo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/2/29 7:24 下午
 */
@Component
public class ScheduleTask2 {

    private static final SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime(){
        //System.out.println("现在时间是："+dateformat.format(new Date()));
    }

}
