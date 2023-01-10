package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "board_game")
public class BoardGameEntity {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "editor_name")
    private String editorName;
    @Column(name = "price")
    private Double price;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "fk_category", referencedColumnName = "label")
    @ManyToOne
    private CategoryEntity category;

    public BoardGameEntity() {}

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEditorName(String editorName) { this.editorName = editorName; }
    public void setPrice(Double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setCategoryLabel(CategoryEntity category) { this.category = category; }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEditorName() { return editorName; }
    public Double getPrice() { return price; }
    public String getDescription() { return description; }
    public CategoryEntity getCategory() { return category; }
}
