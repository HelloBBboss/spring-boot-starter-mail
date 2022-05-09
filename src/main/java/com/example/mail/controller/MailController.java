package com.example.mail.controller;


import com.example.mail.service.IMailService;
import com.example.mail.vo.MailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/")
public class MailController {

    @Autowired
    private IMailService mailService;

    @GetMapping("/send")
    public void sendMail(@RequestBody MailVo mailVo) {
        mailService.sendMail(mailVo);
    }


}