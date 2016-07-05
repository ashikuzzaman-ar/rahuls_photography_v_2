package com.studevs.mvc.controllers;

import com.studevs.mvc.models.FeaturePage;
import com.studevs.mvc.models.Orders;
import com.studevs.mvc.models.OurPackages;
import com.studevs.utils.SendMail;
import com.studevs.utils.providers.ServiceProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import com.studevs.utils.providers.services.OrdersProvider;
import com.studevs.utils.providers.services.OurPackagesProvider;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
            @ModelAttribute(value = "orders") Orders orders,
            BindingResult bindingResult) {

        this.getFeaturePage(model);

        try {

            OurPackagesProvider ourPackagesProvider = (OurPackagesProvider) beanProvider.getBean("ourPackagesProvider");
            List<OurPackages> ourPackageses = ourPackagesProvider.getOurPackages(packageId);
            OurPackages ourPackages;

            if (ourPackageses != null && ourPackageses.size() > 0) {

                ourPackages = ourPackageses.get(0);
                ourPackages.getOrderses().add(orders);
                orders.setOurPackages(ourPackages);
            }

            OrdersProvider ordersProvider = (OrdersProvider) beanProvider.getBean("ordersProvider");

            if (ordersProvider.insertOrders(orders)) {

                String mailSubject = "Rahul's Photography | Form Submission Successful!";
                String emailMessage = "Dear " + orders.getClientName() + ", \n"
                        + "Congratulation!!!!!!!\n"
                        + "Your form is successfully submitted to our database. Our team "
                        + "will check and varify your form information given by you right now. "
                        + "If all your information is correct then a confirmation email will "
                        + "be send to this email address. Untill you get that email please keep "
                        + "this copy of email safe in your inbox. If you don't get any "
                        + "confirmation email withing 7 days then please contact us directly "
                        + "With this copy of email through - info@rahulahasanphotography.com."
                        + "\n\n\n"
                        + "Your provided information which is recorded: \n"
                        + "Order ID: " + orders.getId() + "\n"
                        + "Your Name: " + orders.getClientName() + "\n"
                        + "Your Phone Number: " + orders.getClientPhoneNumber() + "\n"
                        + "Advanced Amount: " + orders.getAdvancedAmount() + "\n"
                        + "Your BKash Number: " + orders.getClientBkshNumber() + "\n"
                        + "BKash Transaction Number: " + orders.getTransactionNumber() + "\n"
                        + "Your Email Address: " + orders.getClientEmail() + "\n"
                        + "Your Email Address: " + orders.getClientEmail() + "\n"
                        + "Event Date: " + orders.getEventDate() + "\n"
                        + "Event Venue: " + orders.getEventVenue() + "\n"
                        + "\n"
                        + "Thank you for using our service!";

                SendMail sendMail = (SendMail) beanProvider.getBean("sendMail");
                sendMail.send(orders.getClientEmail(), mailSubject, emailMessage);
            }

            return "index";
        } catch (Exception e) {

            return "index";
        }
    }
}
