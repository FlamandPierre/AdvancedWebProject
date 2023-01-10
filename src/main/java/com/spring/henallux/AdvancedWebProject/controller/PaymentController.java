package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.*;
import com.spring.henallux.AdvancedWebProject.model.Cart;
import com.spring.henallux.AdvancedWebProject.model.Order;
import com.spring.henallux.AdvancedWebProject.model.OrderLine;
import com.spring.henallux.AdvancedWebProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping(value="/payment")
@SessionAttributes({"order"})
public class PaymentController {
    private OrderDataAccess orderDAO;
    private OrderLineDataAccess orderLineDAO;
    private UserDataAccess userDAO;

    @Autowired
    public PaymentController(OrderDAO orderDAO, OrderLineDAO orderLineDAO, UserDAO userDAO) {
        this.orderDAO = orderDAO;
        this.orderLineDAO = orderLineDAO;
        this.userDAO = userDAO;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String payment(Model model, @ModelAttribute("order") Cart cart, Authentication authentication) {
        User user = (User)authentication.getPrincipal();

        Order newOrder = new Order();
        newOrder.setDate(new Date());
        ArrayList<OrderLine> items = new ArrayList<>(cart.getItems().values());
        newOrder.setUser(user);
        newOrder.setReduction((double)user.getLoyaltyPoints() / 100);

        Double total = cart.getTotalReduction((double)user.getLoyaltyPoints());
        if (total < 0.00) {
            total = -0.00;
        }

        orderDAO.saveOrder(newOrder);
        orderLineDAO.saveOrderItems(items, user.getUsername());

        model.addAttribute(cart);
        model.addAttribute("total", total);
        return "integrated:payment";
    }

    @RequestMapping(value="/success", method=RequestMethod.GET)
    public String success(Model model, @ModelAttribute("order") Cart cart, Authentication authentication) {
        User user = (User)authentication.getPrincipal();
        orderDAO.updateIsPaid(true, user.getUsername());

        Integer nbPoints = (int) Math.round(cart.getTotalReduction((double)user.getLoyaltyPoints()));

        userDAO.updatePoints(user.getUsername(), nbPoints);
        cart.getItems().clear();
        model.addAttribute("successMessage", "Votre paiement a bien été pris en compte.");
        return "integrated:checkout";
    }

    @RequestMapping(value="/cancelled", method=RequestMethod.GET)
    public String cancelled(Model model, @ModelAttribute("order") Cart cart) {
        model.addAttribute("cancelMessage", "Votre paiement a été annulé !");
        model.addAttribute(cart);
        model.addAttribute("orderLine", new OrderLine());
        return "integrated:checkout";
    }
}
