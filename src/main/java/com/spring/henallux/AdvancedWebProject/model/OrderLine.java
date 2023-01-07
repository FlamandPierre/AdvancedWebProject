package com.spring.henallux.AdvancedWebProject.model;


import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class OrderLine {

    private Integer id;
    @NotNull
    @Min(value = 1)
    @Max(value = 99)
    private Integer quantity;
    private Double price;
    private BoardGame boardGame;

    public OrderLine() {}

    public void setId(Integer id) { this.id = id; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setPrice(Double price) { this.price = price; }
    public void setBoardGame(BoardGame boardGame) { this.boardGame = boardGame; }

    public Integer getId() { return id; }
    public Integer getQuantity() { return quantity; }
    public Double getPrice() { return price; }
    public BoardGame getBoardGame() { return boardGame; }
}
