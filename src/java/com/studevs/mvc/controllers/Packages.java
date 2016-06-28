/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.mvc.controllers;

import com.studevs.mvc.models.Admin;
import com.studevs.mvc.models.FeaturePage;
import com.studevs.mvc.models.OurPackages;
import com.studevs.utils.providers.ServiceProvider;
import static com.studevs.utils.providers.ServiceProvider.beanProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import com.studevs.utils.providers.services.OurPackagesProvider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ashik
 */
@Controller
public class Packages implements ServiceProvider {

    private Admin admin;
    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;
    private OurPackagesProvider ourPackagesProvider;

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

    @RequestMapping(value = "packages")
    protected String doGet1(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        this.setFeaturePage(model);

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");

            if (this.admin == null) {

                return "admin_panel";
            } else {

                return "packages";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "packages_remove", method = RequestMethod.GET)
    protected String doGet2(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        this.setFeaturePage(model);

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");

            if (this.admin == null) {

                return "admin_panel";
            } else {

                return "packages";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }

    @RequestMapping(value = "packages_add", method = RequestMethod.GET)
    protected String doGet3(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        this.setFeaturePage(model);

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");

            if (this.admin == null) {

                return "admin_panel";
            } else {

                return "packages";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }

    @RequestMapping(value = "packages_remove", method = RequestMethod.POST)
    protected String doPost1(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "package_id", defaultValue = "") String packageId) {

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");
            this.ourPackagesProvider = (OurPackagesProvider) beanProvider.getBean("ourPackagesProvider");

            if (this.admin == null) {

                this.setFeaturePage(model);

                return "admin_panel";
            } else {

                OurPackages ourPackages = new OurPackages();
                ourPackages.setId(Integer.parseInt(packageId));

                this.ourPackagesProvider.removeOurPackages(ourPackages);

                this.setFeaturePage(model);

                return "packages";
            }

        } catch (Exception e) {

            this.setFeaturePage(model);

            return "team_members";
        }
    }

    @RequestMapping(value = "packages_add", method = RequestMethod.POST)
    protected String doPost2(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("ourPackages") OurPackages ourPackages) {

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");

            if (this.admin == null) {

                this.setFeaturePage(model);

                return "admin_panel";
            } else {

                this.setFeaturePage(model);

                ourPackages.setFeaturePage(this.featurePage);

                this.featurePage.getOurPackages().add(ourPackages);

                this.featurePageProvider.updateFeaturePage(this.featurePage);

                return "packages";
            }

        } catch (Exception e) {

            this.setFeaturePage(model);
            
            return "team_members";
        }
    }
}
