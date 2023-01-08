package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.OrderDAO;
import com.spring.henallux.AdvancedWebProject.model.Order;
import com.spring.henallux.AdvancedWebProject.model.OrderLine;
import com.spring.henallux.AdvancedWebProject.model.User;
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
    private OrderDAO orderDAO;

    @RequestMapping(method= RequestMethod.GET)
    public String payment(Model model, @ModelAttribute("cart") Order order, Authentication authentication) {
        User user = (User)authentication.getPrincipal();

        Order newOrder = new Order();
        ArrayList<OrderLine> items = new ArrayList<>(order.getItems().values());
        newOrder.setUser(user);
        orderDAO.saveOrder(newOrder);

        model.addAttribute(order);
        return "integrated:payment";
    }
}
