package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.model.OrderLine;

import java.util.ArrayList;

public interface OrderLineDataAccess {
    void saveOrderItems(ArrayList<OrderLine> items, String username);
}
