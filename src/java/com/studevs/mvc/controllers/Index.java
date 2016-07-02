/*
Backup Branch is created...
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.mvc.controllers;

import com.studevs.mvc.models.FeaturePage;
import com.studevs.utils.GetBeans;
import com.studevs.utils.MailMail;
import com.studevs.utils.providers.ServiceProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ashik
 */
@Controller
public class Index implements ServiceProvider {

    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;

    @RequestMapping(value = "send_mail", method = RequestMethod.POST)
    public String doPOST0(@RequestParam("email") String email,
            @RequestParam("message") String message,
            @RequestParam("subject") String subject, Model model) {

        GetBeans<MailMail> getBeans = new GetBeans<>();
        getBeans.setFileName("mail_beans.xml");
        MailMail mailMail = getBeans.getBean("mailMail");

        mailMail.sendMail(email, "info@rahulahasanphotography.com", subject, message);

        model.addAttribute("featurePage", this.featurePage);
        model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));

        return "index";

    }

    @RequestMapping(value = "index")
    protected String doGet1(Model model) {

        try {

            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            this.featurePage = this.featurePageProvider.getFeaturePage();

            model.addAttribute("featurePage", this.featurePage);
            model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));

            return "index";
        } catch (Exception e) {

            return "index";
        }
    }
}
