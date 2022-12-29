package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "BoardGame")
public class BoardGameEntity {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "editorName")
    private String editorName;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "fk_category")
    @ManyToOne
    private CategoryEntity category;

    public BoardGameEntity() {}

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEditorName(String editorName) { this.editorName = editorName; }
    public void setPrice(Double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(CategoryEntity category) { this.category = category; }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEditorName() { return editorName; }
    public Double getPrice() { return price; }
    public String getDescription() { return description; }
    public CategoryEntity getCategory() { return category; }
}
