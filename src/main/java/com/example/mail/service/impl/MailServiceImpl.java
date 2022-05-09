package com.example.mail.service.impl;

import com.example.mail.service.IMailService;
import com.example.mail.vo.MailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Date;


@Slf4j
@Service
public class MailServiceImpl implements IMailService {

    @Value("${spring.mail.username}")
    private String sendFrom;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendMail(MailVo mailVo) {
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), false);
            messageHelper.setFrom(sendFrom);
            messageHelper.setTo(mailVo.getTo().split(","));
            messageHelper.setSubject(mailVo.getSubject());
            messageHelper.setSentDate(new Date());
            messageHelper.setText(mailVo.getText());
            mailSender.send(messageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}