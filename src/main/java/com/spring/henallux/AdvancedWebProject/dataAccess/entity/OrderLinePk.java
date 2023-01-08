package com.spring.henallux.AdvancedWebProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderLinePk {
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "boardgame_id")
    private Integer boardgameId;
}
