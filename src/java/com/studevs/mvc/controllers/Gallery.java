package com.studevs.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ashik
 */
@Controller
public class Gallery {
    
    @RequestMapping(value = "gallery")
    protected String doGet1(){
        
        try {
            
            return "gallery";
        } catch (Exception e) {
            
            return "index";
        }
    }
}
