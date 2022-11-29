package com.spring.henallux.AdvancedWebProject.model;

public class BoardGame {

    private Integer id;
    private String name;
    private String editorName;
    private Double price;
    private String description;
    private Category category;

    public BoardGame() {}

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEditorName(String editorName) { this.editorName = editorName; }
    public void setPrice(Double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(Category category) { this.category = category; }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEditorName() { return editorName; }
    public Double getPrice() { return price; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }

}
