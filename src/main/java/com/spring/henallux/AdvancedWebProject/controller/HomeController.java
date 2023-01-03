package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.CategoryDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {

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