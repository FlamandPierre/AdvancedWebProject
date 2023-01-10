package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.model.CategoryTranslation;

import java.util.ArrayList;

public interface CategoryTranslationDataAccess {
    CategoryTranslation getCategoryTranslationByLanguageCodeAndCategoryLabel(String languageCode, String categoryLabel);
    ArrayList<CategoryTranslation> getAllCategoryTranslations();

}
