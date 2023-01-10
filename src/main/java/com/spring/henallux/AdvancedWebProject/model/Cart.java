package com.spring.henallux.AdvancedWebProject.model;

import java.text.DecimalFormat;
import java.util.HashMap;

public class Cart {
    private HashMap<String, OrderLine> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public HashMap<String, OrderLine> getItems() {
        return items;
    }

    public OrderLine getItem(String name) {
        return items.get(name);
    }

    public void addItems(OrderLine orderLine) {
        if (!items.containsKey(orderLine.getItem().getName())) {
            items.put(orderLine.getItem().getName(), orderLine);
        } else {
            items.get(orderLine.getItem().getName()).setQuantity(orderLine.getQuantity());
        }
    }

    public Double getTotal() {
        double total = 0;
        for (OrderLine item : items.values()) {
            total += item.getTotal();
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String totalString = decimalFormat.format(total);
        totalString = totalString.replace(",",".");
        return Double.parseDouble((totalString));
    }
}
