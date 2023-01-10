package com.spring.henallux.AdvancedWebProject.controller;


import com.spring.henallux.AdvancedWebProject.dataAccess.dao.*;
import com.spring.henallux.AdvancedWebProject.model.Cart;
import com.spring.henallux.AdvancedWebProject.model.Category;
import com.spring.henallux.AdvancedWebProject.model.CategoryTranslation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/category/{label}")
public class CategoryController {

    private CategoryDataAccess categoryDAO;
    private CategoryTranslationDataAccess categoryTranslationDAO;

    @Autowired
    public CategoryController(CategoryDAO categoryDAO, CategoryTranslationDAO categoryTranslationDAO) {
        this.categoryDAO = categoryDAO;
        this.categoryTranslationDAO = categoryTranslationDAO;
    }

    @RequestMapping(method= RequestMethod.GET)
    public String getCategory(@PathVariable("label") String label,
                              Model model,
                              Locale locale,
                              @ModelAttribute(value = "order") Cart cart) {
        Category category = categoryDAO.getCategory(label);
        CategoryTranslation categoryTranslation = categoryTranslationDAO.getCategoryTranslationByLanguageCodeAndCategoryLabel(locale.getLanguage(), category.getLabel());
        model.addAttribute("category", category);
        model.addAttribute("categoryTranslation", categoryTranslation);
        model.addAttribute("language", locale.getLanguage());
        return "integrated:category";
    }
}
