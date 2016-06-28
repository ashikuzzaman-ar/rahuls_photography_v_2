/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.mvc.controllers;

import com.studevs.mvc.models.FeaturePage;
import com.studevs.utils.providers.ServiceProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ashik
 */
@Controller
public class Index implements ServiceProvider{

    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;
    
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
