package com.spring.henallux.AdvancedWebProject.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;

public class Order {

    private Integer id;
    private Date date;
    private Boolean isPaid;
    @NotNull
    @DecimalMax(value = "100.0")
    private Double reduction;
    private User user;

    public Order() {
        setDate(new Date());
        setIsPaid(false);
        setReduction(0.00);
    }

    public void setId(Integer id) { this.id = id; }
    public void setDate(Date date) { this.date = date; }
    public void setIsPaid(Boolean isPaid) { this.isPaid = isPaid; }
    public void setReduction(Double reduction) { this.reduction = reduction; }
    public void setUser(User user) { this.user = user; }

    public Integer getId() { return id; }
    public Date getDate() { return date; }
    public Boolean getIsPaid() { return isPaid; }
    public Double getReduction() { return reduction; }
    public User getUser() { return user; }
}
