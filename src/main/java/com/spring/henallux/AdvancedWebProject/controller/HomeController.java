package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.AdvancedWebProject.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/")
@SessionAttributes({HomeController.ORDER})
public class HomeController {
    protected static final String ORDER = "order";

    @ModelAttribute(ORDER)
    public Order order() {
        return new Order();
    }

    private CategoryDataAccess categoryDAO;

    @Autowired
    public HomeController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String getHome (Model model) {
        model.addAttribute("categories", categoryDAO.getAllCategories());
        return "integrated:home";
    }

}