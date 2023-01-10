package com.spring.henallux.AdvancedWebProject.controller;


import com.spring.henallux.AdvancedWebProject.dataAccess.dao.CategoryDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.CategoryDataAccess;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.ItemDAO;
import com.spring.henallux.AdvancedWebProject.dataAccess.dao.ItemDataAccess;
import com.spring.henallux.AdvancedWebProject.model.Cart;
import com.spring.henallux.AdvancedWebProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/category/{label}")
public class CategoryController {

    private CategoryDataAccess categoryDAO;

    @Autowired
    public CategoryController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String getCategory(@PathVariable("label") String label,
                              Model model,
                              @ModelAttribute(value = "order") Cart cart) {
        Category category = categoryDAO.getCategory(label);
        model.addAttribute("category", category);
        return "integrated:category";
    }
}
