package com.tangv.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/2/29 7:56 下午
 */
@Service
public class MailService {

    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender mailSender;
    @Value("${mail.fromMail.addr}")
    private String from;

    public void sendSimpleMessage(String to,String subject,String content){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(content);
        simpleMailMessage.setSubject(subject);
        try {
            mailSender.send(simpleMailMessage);
            logger.info("简单邮件已发送");
        }catch (Exception e){
            logger.error("发送简单邮件异常！",e);
        }
    }

}
