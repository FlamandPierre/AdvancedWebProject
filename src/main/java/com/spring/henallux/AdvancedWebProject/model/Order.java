package com.spring.henallux.AdvancedWebProject.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class Order {

    private Integer id;
    private Date date;
    private Boolean isPaid;
    @NotNull
    @DecimalMax(value = "100.0")
    private Double reduction;
    private User user;
    private OrderLine orderLine;

    public Order() {}

    public void setId(Integer id) { this.id = id; }
    public void setDate(Date date) { this.date = date; }
    public void setIsPaid(Boolean isPaid) { this.isPaid = isPaid; }
    public void setReduction(Double reduction) { this.reduction = reduction; }
    public void setUser(User user) { this.user = user; }
    public void setOrderLine(OrderLine orderLine) { this.orderLine = orderLine; }

    public Integer getId() { return id; }
    public Date getDate() { return date; }
    public Boolean getIsPaid() { return isPaid; }
    public Double getReduction() { return reduction; }
    public User getUser() { return user; }
    public OrderLine getOrderLine() { return orderLine; }

}
