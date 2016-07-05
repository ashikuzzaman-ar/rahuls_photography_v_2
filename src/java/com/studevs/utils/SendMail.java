package com.studevs.utils;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author ashik
 */
public class SendMail {

    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    public boolean send(String recipientEmailAddress, String mailSubject, String emailMessage) {

        boolean isOk = false;

        try {

            this.simpleMailMessage.setTo(recipientEmailAddress);
            this.simpleMailMessage.setSubject(mailSubject);
            this.simpleMailMessage.setText(emailMessage);

            this.mailSender.send(this.simpleMailMessage);
            isOk = true;
        } catch (Exception e) {

            throw new ExceptionInInitializerError(e);
        }

        return isOk;
    }
}
