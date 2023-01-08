package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.model.Order;
import com.spring.henallux.AdvancedWebProject.model.OrderLine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping(value = "/checkout")
@SessionAttributes({"order"})
public class CheckoutController {
    @RequestMapping(method=RequestMethod.GET)
    public String getCheckout(Model model, @ModelAttribute("order") Order order) {
        model.addAttribute(order);
        model.addAttribute("orderLine", new OrderLine());
        return "integrated:checkout";
    }

    @RequestMapping(value="/changeQuantity", method=RequestMethod.POST)
    public String changeQuantity(@ModelAttribute("order") Order order, @ModelAttribute("checkoutItem") OrderLine orderLine) {
        String name = orderLine.getBoardGame().getName();
        Integer quantity = orderLine.getQuantity();
        order.getItem(name).setQuantity(quantity);
        return "integrated:checkout";
    }

    @RequestMapping(value="/delete/{name}", method=RequestMethod.GET)
    public String removeItem(@ModelAttribute("order") Order order, @PathVariable String name) {
        order.getItems().remove(name);
        return "redirect:checkout";
    }
}
