package com.spring.henallux.AdvancedWebProject.controller;

import com.spring.henallux.AdvancedWebProject.dataAccess.dao.*;
import com.spring.henallux.AdvancedWebProject.model.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.security.core.Authentication;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/home")
@SessionAttributes({HomeController.ORDER})
public class HomeController {
    protected static final String ORDER = "order";

    private ItemDataAccess itemDAO;
    private CategoryDataAccess categoryDAO;
    private ArrayList<Item> items;
    private CategoryTranslationDataAccess categoryTranslationDAO;

    private ArrayList<CategoryTranslation> translations;

    @ModelAttribute(ORDER)
    public Cart order() {
        return new Cart();
    }

    @Autowired
    public HomeController(CategoryDAO categoryDAO, ItemDAO itemDAO, CategoryTranslationDAO categoryTranslationDAO) {
        this.categoryDAO = categoryDAO;
        this.itemDAO = itemDAO;
        this.categoryTranslationDAO = categoryTranslationDAO;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String getHome (Authentication authentication, Model model, Locale locale, @ModelAttribute(value = "order") Cart cart) {
        items = itemDAO.findAll();
        if(authentication != null){
            User userDetails = (User) authentication.getPrincipal();
            model.addAttribute("currentUser",userDetails);
        }
        translations = new ArrayList<>();
        ArrayList<Category> categories = categoryDAO.getAllCategories();
        ArrayList<CategoryTranslation> categoryTranslations = categoryTranslationDAO.getAllCategoryTranslations();
        for (Category category : categories) {
            for (CategoryTranslation categoryTranslation : categoryTranslations) {
                if (categoryTranslation.getLanguageCode().equals(locale.getLanguage())
                        && categoryTranslation.getCategoryLabel().equals(category.getLabel())) {
                    translations.add(categoryTranslation);
                    break;
                }
            }
        }
        model.addAttribute("categories", categories);
        model.addAttribute("translations", translations);
        model.addAttribute("items", items);
        return "integrated:home";
    }
}