package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.model.Item;

import java.util.ArrayList;

public interface ItemDataAccess {
    ArrayList<Item> findAll();
    Item findByName(String name);
}
