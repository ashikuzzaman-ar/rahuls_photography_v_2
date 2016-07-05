package com.studevs.mvc.controllers;

import com.studevs.mvc.models.Admin;
import com.studevs.mvc.models.FeaturePage;
import com.studevs.utils.SendMail;
import com.studevs.utils.providers.ServiceProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import com.studevs.utils.providers.services.OrdersProvider;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ashik
 */
@Controller
public class Orders implements ServiceProvider {

    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;
    private OrdersProvider ordersProvider;
    private List currentOrderList;
    private List deliveredOrderList;
    private Admin admin;

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

    @RequestMapping(value = "orders")
    protected String doGet1(Model model,
            HttpServletRequest request,
            HttpServletResponse response) {

        this.getFeaturePage(model);
        this.admin = (Admin) request.getSession().getAttribute("admin");

        try {

            if (this.admin != null) {

                this.ordersProvider = (OrdersProvider) beanProvider.getBean("ordersProvider");
                this.currentOrderList = this.ordersProvider.getCurrentOrders();
                this.deliveredOrderList = this.ordersProvider.getDeliveredOrders();

                model.addAttribute("currentOrderList", this.currentOrderList);
                model.addAttribute("deliveredOrderList", this.deliveredOrderList);

                return "orders";
            } else {

                return "index";
            }
        } catch (Exception e) {

            return "index";
        }
    }

    @RequestMapping(value = "orders_update")
    protected String doPost1(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "button", defaultValue = "") String button,
            @ModelAttribute(value = "orders") com.studevs.mvc.models.Orders orders,
            BindingResult bindingResult) {

        this.getFeaturePage(model);
        this.admin = (Admin) request.getSession().getAttribute("admin");

        try {

            if (this.admin != null) {

                this.ordersProvider = (OrdersProvider) beanProvider.getBean("ordersProvider");
                this.ordersProvider.updateOrders(orders);

                this.currentOrderList = this.ordersProvider.getCurrentOrders();
                this.deliveredOrderList = this.ordersProvider.getDeliveredOrders();

                model.addAttribute("currentOrderList", this.currentOrderList);
                model.addAttribute("deliveredOrderList", this.deliveredOrderList);

                if (button.equals("Update And Send Mail")) {

                    this.sendAppointedConfirmationMain(this.ordersProvider.getSingleOrders(orders.getId()));
                }

                return "orders";
            } else {

                return "index";
            }
        } catch (Exception e) {

            return "index";
        }
    }

    private void sendAppointedConfirmationMain(com.studevs.mvc.models.Orders orders) {

        try {

            String subject = "Successfully submitted your order to Rahul's Photography!";
            String mail = "Dear " + orders.getClientName() + ", \n"
                    + "Your order is varified sucessfully and it is approved by "
                    + "our team. We are very happy to announce that we "
                    + "will cover your event! If you have any query "
                    + "then please call us directly. \n"
                    + "Overview of your provided information: \n"
                    + "Your Name: " + orders.getClientName() + ", \n"
                    + "Your Phoen Number: " + orders.getClientPhoneNumber() + ", \n"
                    + "Your Email Address: " + orders.getClientEmail() + ", \n"
                    + "BKash Number: " + orders.getClientBkshNumber() + ", \n"
                    + "Fund Transcation Number: " + orders.getTransactionNumber() + ", \n"
                    + "Package Price: " + orders.getOurPackages().getPackagePrice() + ", \n"
                    + "Advanced Ammount: " + orders.getAdvancedAmount() + ", \n"
                    + "Due Ammount: " + (orders.getOurPackages().getPackagePrice() - orders.getAdvancedAmount()) + ", \n"
                    + "Event Venue: " + orders.getEventVenue() + ", \n"
                    + "Event Date: " + orders.getEventDate() + ", \n"
                    + "Delivery Date: " + orders.getDeliveryDate() + ", \n"
                    + "\n"
                    + "Thank You Very Much\n";

            SendMail sendMail = (SendMail) beanProvider.getBean("sendMail");
            sendMail.send(orders.getClientEmail(), subject, mail);
        } catch (Exception e) {

            throw new ExceptionInInitializerError(e);
        }
    }
}
