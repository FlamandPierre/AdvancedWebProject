package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.AdvancedWebProject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDAO implements OrderDataAccess {
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order) {
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        orderRepository.save(orderEntity);
    }
}
