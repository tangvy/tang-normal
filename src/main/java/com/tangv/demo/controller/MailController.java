package com.tangv.demo.controller;

import com.tangv.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/2/29 8:09 下午
 */
@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/mail")
    //@Scheduled(cron = "*/6 * * * * ?")
    public void sendMail() throws Exception{
        System.out.println("发送了一条邮件");
        mailService.sendSimpleMessage("354266741@qq.com","张总好","hello");
    }
}
