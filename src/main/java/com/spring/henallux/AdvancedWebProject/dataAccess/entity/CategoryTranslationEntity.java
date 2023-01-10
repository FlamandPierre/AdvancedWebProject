package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import com.spring.henallux.AdvancedWebProject.dataAccess.util.CategoryTranslationKey;
import com.spring.henallux.AdvancedWebProject.model.Category;
import com.spring.henallux.AdvancedWebProject.model.Language;

import javax.persistence.*;

@Entity
@IdClass(CategoryTranslationKey.class)
@Table(name = "category_translation")
public class CategoryTranslationEntity {
    @Column(name = "category_name")
    private String categoryName;
    @Id
    @Column(name = "fk_language")
    private String languageCode;
    @Id
    @Column(name = "fk_category")
    private String categoryLabel;

    public CategoryTranslationEntity() {}

    public void setLanguageCode(String languageCode) { this.languageCode = languageCode; }
    public void setCategoryLabel(String categoryLabel) { this.categoryLabel = categoryLabel; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getLanguageCode() { return languageCode; }
    public String getCategoryLabel() { return categoryLabel; }
    public String getCategoryName() { return categoryName; }

}
