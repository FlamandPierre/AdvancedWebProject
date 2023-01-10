package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.model.Category;

import java.util.ArrayList;

public interface CategoryDataAccess {

    ArrayList<Category> getAllCategories();
    Category getCategory(String label);
}