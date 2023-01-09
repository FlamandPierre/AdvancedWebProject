package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.OrderDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.OrderDataAccess;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.OrderLineDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.OrderLineDataAccess;
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

@Controller
@RequestMapping(value="/payment")
@SessionAttributes({"order"})
public class PaymentController {
    private OrderDataAccess orderDAO;
    private OrderLineDataAccess orderLineDAO;

    @Autowired
    public PaymentController(OrderDAO orderDAO, OrderLineDAO orderLineDAO) {
        this.orderDAO = orderDAO;
        this.orderLineDAO = orderLineDAO;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String payment(Model model, @ModelAttribute("cart") Order order, Authentication authentication) {
        User user = (User)authentication.getPrincipal();

        Order newOrder = new Order();
        ArrayList<OrderLine> items = new ArrayList<>(order.getItems().values());
        newOrder.setUser(user);
        orderDAO.saveOrder(newOrder);
        orderLineDAO.saveOrderItems(items, user.getUsername());

        model.addAttribute(order);
        return "integrated:payment";
    }

    @RequestMapping(value="/success", method=RequestMethod.GET)
    public String success(Model model, @ModelAttribute("order") Order order, Authentication authentication) {
        User user = (User)authentication.getPrincipal();
        orderDAO.updateIsPaid(true, user.getUsername());
        order.getItems().clear();
        model.addAttribute("successMessage", "Votre paiement a bien été pris en compte.");
        return "integrated:checkout";
    }

    @RequestMapping(value="/cancelled", method=RequestMethod.GET)
    public String cancelled(Model model, @ModelAttribute("order") Order order) {
        model.addAttribute("cancelMessage", "Votre paiement a été annulé !");
        model.addAttribute(order);
        model.addAttribute("orderLine", new OrderLine());
        return "integrated:checkout";
    }
}
