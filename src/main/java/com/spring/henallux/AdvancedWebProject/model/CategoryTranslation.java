package com.spring.henallux.AdvancedWebProject.model;

public class CategoryTranslation {

    private String languageCode;
    private String categoryLabel;
    private String categoryName;

    public CategoryTranslation() {}

    public void setLanguageCode(String languageCode) { this.languageCode = languageCode; }
    public void setCategoryLabel(String categoryLabel) { this.categoryLabel = categoryLabel; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getLanguageCode() { return languageCode; }
    public String getCategoryLabel() { return categoryLabel; }
    public String getCategoryName() { return categoryName; }
}
