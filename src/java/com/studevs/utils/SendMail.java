package com.studevs.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 *
 * @author ashik
 */
public class SendMail {

    private JavaMailSender javaMailSender;
    private SimpleMailMessage simpleMailMessage;

    public SendMail(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public boolean send(String recipientEmailAddress, String mailSubject, String emailMessage) {

        boolean isOk = false;
        
        try {
            
            
        } catch (Exception e) {
            
            throw new ExceptionInInitializerError(e);
        }
        
        return isOk;
    }
}
