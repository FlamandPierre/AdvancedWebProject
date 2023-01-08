package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "order_line")
public class OrderLineEntity {

    @EmbeddedId
    private OrderLinePk orderLinePk;

    @Column(name = "date")
    private Date date;

    @Column(name = "is_paid")
    private Boolean isPaid;

    @Column(name = "reduction")
    private Integer reduction;

    @JoinColumn(name = "fk_username")
    @ManyToOne
    private CategoryEntity username;

    public OrderLineEntity() {}

    public OrderLinePk getOrderLinePk() {
        return orderLinePk;
    }

    public void setOrderLinePk(OrderLinePk orderLinePk) {
        this.orderLinePk = orderLinePk;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean paid) {
        isPaid = paid;
    }

    public Integer getReduction() {
        return reduction;
    }

    public void setReduction(Integer reduction) {
        this.reduction = reduction;
    }

    public CategoryEntity getUsername() {
        return username;
    }

    public void setUsername(CategoryEntity username) {
        this.username = username;
    }
}
