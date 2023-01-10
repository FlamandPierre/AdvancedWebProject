package com.spring.henallux.AdvancedWebProject.dataAccess.util;

import java.io.Serializable;

public class CategoryTranslationKey implements Serializable {

    private String languageCode;
    private String categoryLabel;

    public CategoryTranslationKey() {}

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getLanguageCode() {
        return languageCode;
    }
    public String getCategoryLabel() {
        return categoryLabel;
    }
}
