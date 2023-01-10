package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.ItemDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.ItemDataAccess;
import com.spring.henallux.AdvancedWebProject.model.Cart;
import com.spring.henallux.AdvancedWebProject.model.Item;
import com.spring.henallux.AdvancedWebProject.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping(value = "/")
@SessionAttributes({HomeController.ORDER})
public class HomeController {
    protected static final String ORDER = "order";

    private ItemDataAccess itemDAO;
    private CategoryDataAccess categoryDAO;
    private ArrayList<Item> items;

    @ModelAttribute(ORDER)
    public Cart order() {
        return new Cart();
    }

    @Autowired
    public HomeController(CategoryDAO categoryDAO, ItemDAO itemDAO) {
        this.categoryDAO = categoryDAO;
        this.itemDAO = itemDAO;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String getHome (Model model, @ModelAttribute(value = "order") Cart cart) {
        items = itemDAO.findAll();

        model.addAttribute("categories", categoryDAO.getAllCategories());
        model.addAttribute("items", items);
        return "integrated:home";
    }
}