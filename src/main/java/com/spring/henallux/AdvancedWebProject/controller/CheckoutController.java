package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.model.Cart;
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
    public String getCheckout(Model model, @ModelAttribute("order") Cart cart) {
        model.addAttribute(cart);
        model.addAttribute("orderLine", new OrderLine());
        return "integrated:checkout";
    }

    @RequestMapping(value="/changeQuantity", method=RequestMethod.POST)
    public String changeQuantity(@ModelAttribute("order") Cart cart, @ModelAttribute("orderLine") OrderLine orderLine) {
        String name = orderLine.getItem().getName();
        Integer quantity = orderLine.getQuantity();
        cart.getItem(name).setQuantity(quantity);
        return "redirect:/checkout";
    }

    @RequestMapping(value="/delete/{name}", method=RequestMethod.GET)
    public String removeItem(@ModelAttribute("order") Cart cart, @PathVariable String name) {
        cart.getItems().remove(name);
        return "redirect:/checkout";
    }
}
