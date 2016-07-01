package com.studevs.mvc.controllers;

import com.studevs.mvc.models.FeaturePage;
import com.studevs.mvc.models.Orders;
import com.studevs.mvc.models.OurPackages;
import com.studevs.utils.providers.ServiceProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import com.studevs.utils.providers.services.OrdersProvider;
import com.studevs.utils.providers.services.OurPackagesProvider;
import java.util.List;
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
public class PackageBooking implements ServiceProvider {

    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;

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

    @RequestMapping(value = "package_booking", method = RequestMethod.GET)
    protected String doGet1(Model model) {

        this.getFeaturePage(model);

        try {

            return "redirect:index#pricing";
        } catch (Exception e) {

            return "index";
        }
    }

    @RequestMapping(value = "package_booking_submit", method = RequestMethod.GET)
    protected String doGet2(Model model) {

        this.getFeaturePage(model);

        try {

            return "redirect:index#pricing";
        } catch (Exception e) {

            return "index";
        }
    }

    @RequestMapping(value = "package_booking", method = RequestMethod.POST)
    protected String doPost1(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "id", defaultValue = "") Integer packageId,
            @RequestParam(value = "packageName", defaultValue = "") String packageName,
            @RequestParam(value = "packagePrice", defaultValue = "") String packagePrice) {

        this.getFeaturePage(model);

        try {

//            OurPackagesProvider ourPackagesProvider = (OurPackagesProvider) beanProvider.getBean("ourPackagesProvider");
//            List<OurPackages> ourPackageses = ourPackagesProvider.getOurPackages(packageId);
//
//            if (ourPackageses != null && ourPackageses.size() > 0) {
//
//                OurPackages ourPackages = ourPackageses.get(0);
//                model.addAttribute("ourPackages", ourPackages);
//            }
            model.addAttribute("packagePrice", packagePrice);
            model.addAttribute("packageName", packageName);
            model.addAttribute("packageId", packageId);
            return "package_booking";
        } catch (Exception e) {

            return "index";
        }
    }

    @RequestMapping(value = "package_booking_submit", method = RequestMethod.POST)
    protected String doPost2(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "packageId", defaultValue = "") Integer packageId,
            @ModelAttribute(value = "orders") Orders orders) {

        this.getFeaturePage(model);

        try {

            OurPackagesProvider ourPackagesProvider = (OurPackagesProvider) beanProvider.getBean("ourPackagesProvider");
            List<OurPackages> ourPackageses = ourPackagesProvider.getOurPackages(packageId);
            OurPackages ourPackages = null;

            if (ourPackageses != null && ourPackageses.size() > 0) {

                ourPackages = ourPackageses.get(0);
                ourPackages.getOrderses().add(orders);
                orders.setOurPackages(ourPackages);
            }

            OrdersProvider ordersProvider = (OrdersProvider) beanProvider.getBean("ordersProvider");

            if (ordersProvider.insertOrders(orders)) {

            }

            model.addAttribute("ourPackages", ourPackages);
            return "package_booking";
        } catch (Exception e) {

            return "index";
        }
    }
}
