package com.spring.henallux.AdvancedWebProject.model;

public class Translation {

    private Language language;
    private Category category;
    private String name;

    public Translation() {}

    public void setLanguage(Language language) { this.language = language; }
    public void setCategory(Category category) { this.category = category; }
    public void setName(String name) { this.name = name; }

    public Language getLanguage() { return language; }
    public Category getCategory() { return category; }
    public String getName() { return name; }

}
