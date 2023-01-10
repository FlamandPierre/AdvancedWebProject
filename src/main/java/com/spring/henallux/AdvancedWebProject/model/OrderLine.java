package com.spring.henallux.AdvancedWebProject.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;

public class OrderLine {

    private Integer id;
    @NotNull
    @Min(value = 1)
    @Max(value = 99)
    private Integer quantity;
    private Double price;
    private Item item;

    public OrderLine(Item item, Integer quantity) {
        setQuantity(quantity);
        setItem(item);
    }

    public OrderLine() {}

    public void setId(Integer id) { this.id = id; }
    public void setQuantity(Integer quantity) {
        if (quantity < 1) {
            this.quantity = 1;
        } else {
            if (quantity > 99) {
                this.quantity = 99;
            } else {
                this.quantity = quantity;
            }
        }
    }
    public void addQuantity(Integer quantity) {
        this.quantity += quantity;
    }
    public void setPrice(Double price) { this.price = price; }
    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getId() { return id; }
    public Integer getQuantity() { return quantity; }
    public Double getPrice() { return price; }
    public Item getItem() {
        return item;
    }

    public Double getTotal() {
        DecimalFormat df = new DecimalFormat("0.00");
        Double total = quantity * item.getUnitPrice();
        String totalStr = df.format(total);
        totalStr = totalStr.replace(",", ".");
        return Double.parseDouble(totalStr);
    }
}
