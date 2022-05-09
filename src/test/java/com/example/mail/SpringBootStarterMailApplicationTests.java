package com.example.mail;

import com.example.mail.service.IMailService;
import com.example.mail.vo.MailVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = SpringBootStarterMailApplication.class)
@ActiveProfiles("dev")
class SpringBootStarterMailApplicationTests {


    @Autowired
    private IMailService mailService;

    @Test
    public void contextLoads() {
        MailVo mailVo = new MailVo();
        mailVo.setSubject("开发测试发邮件");
        mailVo.setText("这个是测试数据");
        mailVo.setTo("123456@qq.com");
        mailService.sendMail(mailVo);
        System.out.println("邮件发送成功");
    }

}
