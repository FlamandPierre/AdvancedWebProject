package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="category")
public class CategoryEntity {
    @Id
    @Column(name = "label")
    private String label;


    public CategoryEntity() {}

    public CategoryEntity(String label) {
        setLabel(label);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
