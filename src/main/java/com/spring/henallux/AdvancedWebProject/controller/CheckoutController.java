package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.model.Order;
import com.spring.henallux.AdvancedWebProject.model.OrderLine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/checkout")
@SessionAttributes({"order"})
public class CheckoutController {
    @RequestMapping(method = RequestMethod.GET)
    public String getCheckout(Model model, @ModelAttribute("order") Order order) {
        model.addAttribute(order);
        model.addAttribute("orderLine", new OrderLine());
        return "integrated:checkout";
    }
}
