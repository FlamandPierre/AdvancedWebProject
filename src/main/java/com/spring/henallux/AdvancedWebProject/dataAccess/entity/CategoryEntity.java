package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @Column(name="label")
    private String label;

    public CategoryEntity() {}

    public void setLabel(String label) { this.label = label; }

    public String getLabel() { return label; }
}
