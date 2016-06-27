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

    @RequestMapping(value = "team_members")
    protected String doGet1(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");
            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");

            if (this.admin == null) {

                return "admin_panel";
            } else {

                this.featurePage = this.featurePageProvider.getFeaturePage();

                if (this.featurePage.getOurTeamMembers() != null) {

                    model.addAttribute("ourTeams", this.featurePage.getOurTeamMembers());
                    model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));
                }

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

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");
            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");

            if (this.admin != null) {

                this.featurePage = this.featurePageProvider.getFeaturePage();

                if (this.featurePage.getOurTeamMembers() != null && this.featurePage.getOurTeamMembers().size() > 0) {

                    model.addAttribute("ourTeams", this.featurePage.getOurTeamMembers());
                    model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));
                }

                return "team_members";
            } else {

                return "admin_panel";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }

    @RequestMapping(value = "team_members_remove", method = RequestMethod.GET)
    protected String doGet3(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");
            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");

            if (this.admin != null) {

                this.featurePage = this.featurePageProvider.getFeaturePage();

                if (this.featurePage.getOurTeamMembers() != null && this.featurePage.getOurTeamMembers().size() > 0) {

                    model.addAttribute("ourTeams", this.featurePage.getOurTeamMembers());
                    model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));
                }

                return "team_members";
            } else {

                return "admin_panel";
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

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");
            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");

            if (this.admin != null) {

                if (profilePicture != null) {

                    ourTeam.setProfilePicture(profilePicture.getBytes());
                }

                this.featurePage = this.featurePageProvider.getFeaturePage();

                ourTeam.setFeaturePage(this.featurePage);

                this.featurePage.getOurTeamMembers().add(ourTeam);

                this.featurePageProvider.updateFeaturePage(this.featurePage);

                if (this.featurePage.getOurTeamMembers() != null && this.featurePage.getOurTeamMembers().size() > 0) {

                    model.addAttribute("ourTeams", this.featurePage.getOurTeamMembers());
                    model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));
                }

                return "team_members";
            } else {

                return "admin_panel";
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

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");
            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            this.ourTeamProvider = (OurTeamProvider) beanProvider.getBean("ourTeamProvider");

            if (this.admin != null) {

                OurTeam ourTeam = new OurTeam();
                ourTeam.setId(Integer.parseInt(memberId));
                
                this.ourTeamProvider.removeOurTeam(ourTeam);
                
                this.featurePage = this.featurePageProvider.getFeaturePage();

                if (this.featurePage.getOurTeamMembers() != null) {

                    model.addAttribute("ourTeams", this.featurePage.getOurTeamMembers());
                    model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));
                }

                return "team_members";
            } else {

                return "admin_panel";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }
}
