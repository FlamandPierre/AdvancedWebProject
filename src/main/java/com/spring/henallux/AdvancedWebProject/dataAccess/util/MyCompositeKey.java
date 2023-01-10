package com.spring.henallux.AdvancedWebProject.dataAccess.util;

import java.io.Serializable;

public class MyCompositeKey implements Serializable {
    private Integer idOrder;
    private Integer idBoardGame;

    public MyCompositeKey() {}

    public void setIdOrder(Integer fk_order) {
        this.idOrder = fk_order;
    }

    public void setIdBoardGame(Integer fk_boardgame) {
        this.idBoardGame = fk_boardgame;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public Integer getIdBoardGame() {
        return idBoardGame;
    }
}
