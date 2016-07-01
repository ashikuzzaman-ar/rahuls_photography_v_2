/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sajid
 */
@Controller
public class SecurityContext {

    @RequestMapping("loginpage")
    public String do1() {
        return "loginpage";
    }
}
