package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.AdvancedWebProject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderDAO implements OrderDataAccess {
    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public void saveOrder(Order order) {
        OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
        orderRepository.save(orderEntity);
    }

    @Transactional
    @Override
    public void updateIsPaid(boolean isPaid, String username) {
        OrderEntity orderEntity = orderRepository.findFirstByeMailUserOrderByIdDesc(username);
        orderEntity.setIsPaid(isPaid);
        orderRepository.save(orderEntity);
    }
}
