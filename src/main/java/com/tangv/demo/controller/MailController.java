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
    @Scheduled(cron = "*/6 * * * * ?")
    public void sendMail() throws Exception{
        mailService.sendSimpleMessage("2328192991@qq.com","百万好","hello");
    }
}
