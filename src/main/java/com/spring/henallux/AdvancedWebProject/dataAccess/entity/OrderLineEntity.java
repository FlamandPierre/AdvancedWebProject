package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import com.spring.henallux.AdvancedWebProject.dataAccess.util.MyCompositeKey;

import javax.persistence.*;

@Entity
@IdClass(MyCompositeKey.class)
@Table(name = "order_line")
public class OrderLineEntity {
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;
    @Id
    @Column(name = "fk_order")
    private Integer idOrder;
    @Id
    @Column(name = "fk_boardgame")
    private Integer idBoardGame;

    public OrderLineEntity(Integer quantity, Double price, Integer idOrder, Integer idBoardGame) {
        setQuantity(quantity);
        setPrice(price);
        setIdOrder(idOrder);
        setIdBoardGame(idBoardGame);
    }

    public OrderLineEntity() {}

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdBoardGame(Integer idBoardGame) {
        this.idBoardGame = idBoardGame;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public Integer getIdBoardGame() {
        return idBoardGame;
    }
}
