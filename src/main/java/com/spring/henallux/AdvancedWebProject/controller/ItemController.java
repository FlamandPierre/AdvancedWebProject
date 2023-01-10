package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.ItemDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.ItemDataAccess;
import com.spring.henallux.AdvancedWebProject.model.Cart;
import com.spring.henallux.AdvancedWebProject.model.Item;
import com.spring.henallux.AdvancedWebProject.model.Order;
import com.spring.henallux.AdvancedWebProject.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/item")
@SessionAttributes({"order"})
public class ItemController {
    private ItemDataAccess itemDAO;
    private Item item;

    @Autowired
    public ItemController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String item(Model model, @RequestParam(required = false) String name) {
        item = itemDAO.findByName(name);

        model.addAttribute(item);
        model.addAttribute("newItem", new OrderLine());
        return "integrated:item";
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public String addData(Model model, @ModelAttribute("order") Cart cart, @Valid @ModelAttribute(value = "newItem") OrderLine item, final BindingResult errors) {
        if (!errors.hasErrors()) {
            cart.addItems(item);
        }
        model.addAttribute(this.item);
        return "integrated:item";
    }
}
