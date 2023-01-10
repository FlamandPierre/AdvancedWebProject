package com.spring.henallux.AdvancedWebProject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.DecimalFormat;

public class Item {
    private Integer id;
    @NotNull
    @Size(max = 150)
    private String name;
    @NotNull
    @Size(max = 150)
    private String description;
    @NotNull
    @Min(0)
    private Double unitPrice;
    @NotNull
    private String categoryId;
    private Reduction reduction;

    public Item() {}

    public Item(Integer id, String name, String description, Double unitPrice, String categoryId) {
        setId(id);
        setName(name);
        setDescription(description);
        setUnitPrice(unitPrice);
        setCategoryId(categoryId);
        setReduction(null);
    }

    public Double getPriceReduc() {
        if (reduction != null) {
            return unitPrice - getPromotionAmount(reduction.getNbPoint(), unitPrice);
        } else {
            return unitPrice;
        }
    }

    public Double getPromotionAmount(int promotion, double unitPrice) {
        DecimalFormat df = new DecimalFormat("0.00");
        Double result = (double)promotion / 100;
        Double total = unitPrice - promotion;
        String totalStr = df.format(total);
        totalStr = totalStr.replace(",", ".");
        return Double.parseDouble(totalStr);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setReduction(Reduction reduction) {
        this.reduction = reduction;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Reduction getReduction() {
        return reduction;
    }
}
