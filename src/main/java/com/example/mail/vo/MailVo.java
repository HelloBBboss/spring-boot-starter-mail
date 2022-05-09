package com.example.mail.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MailVo {

    //邮件id
    private String id;

    //邮件接收人
    private String to;

    //邮件主题
    private String subject;

    //邮件内容
    private String text;


}