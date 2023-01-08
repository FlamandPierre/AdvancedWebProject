package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "`order`")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "`date`")
    private Date date;
    @Column(name = "is_paid")
    private Boolean isPaid;
    @Column(name = "reduction")
    private Double reduction;
    @Column(name = "fk_user")
    private String eMailUser;

    public OrderEntity(Integer id, Date date, Boolean isPaid, Double reduction, String eMailUser) {
        setId(id);
        setDate(date);
        setIsPaid(isPaid);
        setReduction(reduction);
        setEMailUser(eMailUser);
    }

    public OrderEntity() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }

    public void setEMailUser(String eMailUser) {
        this.eMailUser = eMailUser;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public Double getReduction() {
        return reduction;
    }

    public String geteMailUser() {
        return eMailUser;
    }
}
