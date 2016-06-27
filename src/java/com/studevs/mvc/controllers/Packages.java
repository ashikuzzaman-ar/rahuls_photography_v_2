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

    @RequestMapping(value = "packages")
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

                if (this.featurePage.getOurPackages() != null) {

                    model.addAttribute("ourPackages", this.featurePage.getOurPackages());
                }

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

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");
            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");

            if (this.admin != null) {

                this.featurePage = this.featurePageProvider.getFeaturePage();

                if (this.featurePage.getOurPackages() != null) {

                    model.addAttribute("ourPackages", this.featurePage.getOurPackages());
                }

                return "packages";
            } else {

                return "admin_panel";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }

    @RequestMapping(value = "packages_add", method = RequestMethod.GET)
    protected String doGet3(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        try {

            this.admin = (Admin) request.getSession().getAttribute("admin");
            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");

            if (this.admin != null) {

                this.featurePage = this.featurePageProvider.getFeaturePage();

                if (this.featurePage.getOurPackages() != null) {

                    model.addAttribute("ourPackages", this.featurePage.getOurPackages());
                }

                return "packages";
            } else {

                return "admin_panel";
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
            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            this.ourPackagesProvider = (OurPackagesProvider) beanProvider.getBean("ourPackagesProvider");

            if (this.admin != null) {

                OurPackages ourPackages = new OurPackages();
                ourPackages.setId(Integer.parseInt(packageId));

                this.ourPackagesProvider.removeOurPackages(ourPackages);

                this.featurePage = this.featurePageProvider.getFeaturePage();

                if (this.featurePage.getOurPackages() != null) {

                    model.addAttribute("ourPackages", this.featurePage.getOurPackages());
                }

                return "packages";
            } else {

                return "admin_panel";
            }

        } catch (Exception e) {

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
            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");

            if (this.admin != null) {

                this.featurePage = this.featurePageProvider.getFeaturePage();

                ourPackages.setFeaturePage(this.featurePage);

                this.featurePage.getOurPackages().add(ourPackages);

                this.featurePageProvider.updateFeaturePage(this.featurePage);

                if (this.featurePage.getOurPackages() != null && this.featurePage.getOurPackages().size() > 0) {

                    model.addAttribute("ourPackages", this.featurePage.getOurPackages());
                }

                return "packages";
            } else {

                return "admin_panel";
            }

        } catch (Exception e) {

            return "team_members";
        }
    }
}
