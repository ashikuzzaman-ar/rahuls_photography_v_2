/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.mvc.controllers;

import com.studevs.mvc.models.FeaturePage;
import com.studevs.utils.SendMail;
import com.studevs.utils.providers.ServiceProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ashik
 */
@Controller
public class Index implements ServiceProvider {

    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;

    @RequestMapping(value = "index")
    protected String doGet1(Model model) {

        try {

            this.getFeaturePage(model);

            return "index";
        } catch (Exception e) {

            return "index";
        }
    }

    @RequestMapping(value = "send_email_message")
    protected String doPost1(Model model,
            @RequestParam(value = "senderName", defaultValue = "") String senderName,
            @RequestParam(value = "senderEmail", defaultValue = "") String senderEmail,
            @RequestParam(value = "emailSubject", defaultValue = "") String emailSubject,
            @RequestParam(value = "emailMessage", defaultValue = "") String emailMessage) {

        this.getFeaturePage(model);

        try {

            emailMessage = "Dear Rahul,\n"
                    + "You have a new mail message from \"" + senderName + "\"\n"
                    + "Sender Email: \"" + senderEmail + "\"\n"
                    + "Email Subject: \"" + emailSubject + "\"\n"
                    + "Email Body: \n\n"
                    + emailMessage;

            SendMail sendMail = (SendMail) beanProvider.getBean("sendMail");
            sendMail.send("info@rahulahasanphotography.com", emailSubject, emailMessage);
            return "index";
        } catch (Exception e) {

            return "index";
        }
    }

    private void getFeaturePage(Model model) {

        try {

            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            this.featurePage = this.featurePageProvider.getFeaturePage();

            model.addAttribute("featurePage", this.featurePage);
            model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));
        } catch (Exception e) {

            throw new ExceptionInInitializerError(e);
        }
    }
}
