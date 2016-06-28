/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.mvc.controllers;

import com.studevs.mvc.models.Admin;
import com.studevs.mvc.models.FeaturePage;
import com.studevs.mvc.models.OurTeam;
import com.studevs.utils.providers.ServiceProvider;
import static com.studevs.utils.providers.ServiceProvider.beanProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import com.studevs.utils.providers.services.OurTeamProvider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ashik
 */
@Controller
public class TeamMembers implements ServiceProvider {

    private Admin admin;
    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;
    private OurTeamProvider ourTeamProvider;

    private void setFeaturePage(Model model) {

        try {

            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            this.featurePage = this.featurePageProvider.getFeaturePage();

            model.addAttribute("featurePage", this.featurePage);
            model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));
        } catch (Exception e) {

            throw new ExceptionInInitializerError(e);
        }
    }

    @RequestMapping(value = "team_members")
    protected String doGet1(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        this.setFeaturePage(model);

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");

            if (this.admin == null) {

                return "admin_panel";
            } else {

                return "team_members";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "team_members_add", method = RequestMethod.GET)
    protected String doGet2(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        this.setFeaturePage(model);

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");

            if (this.admin == null) {

                return "admin_panel";
            } else {

                return "team_members";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }

    @RequestMapping(value = "team_members_remove", method = RequestMethod.GET)
    protected String doGet3(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        this.setFeaturePage(model);

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");

            if (this.admin == null) {

                return "admin_panel";
            } else {

                return "team_members";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }

    @RequestMapping(value = "team_members_add", method = RequestMethod.POST)
    protected String doPost1(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "profilePicture") MultipartFile profilePicture,
            @ModelAttribute("ourTeam") OurTeam ourTeam,
            BindingResult bindingResult) {

        this.setFeaturePage(model);
        
        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");

            if (this.admin == null) {
                
                return "admin_panel";
            } else {
                
                if (profilePicture != null) {

                    ourTeam.setProfilePicture(profilePicture.getBytes());
                }

                ourTeam.setFeaturePage(this.featurePage);

                this.featurePage.getOurTeamMembers().add(ourTeam);

                this.featurePageProvider.updateFeaturePage(this.featurePage);

                return "team_members";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }

    @RequestMapping(value = "team_members_remove", method = RequestMethod.POST)
    protected String doPost2(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "member_id", defaultValue = "") String memberId) {

        this.setFeaturePage(model);
        
        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");
            this.ourTeamProvider = (OurTeamProvider) beanProvider.getBean("ourTeamProvider");

            if (this.admin == null) {
                
                return "admin_panel";
            } else {
                
                OurTeam ourTeam = new OurTeam();
                ourTeam.setId(Integer.parseInt(memberId));

                this.ourTeamProvider.removeOurTeam(ourTeam);

                return "team_members";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }
}
