package com.spring.henallux.AdvancedWebProject.dataAccess.dao;

import com.spring.henallux.AdvancedWebProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.OrderLineRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.AdvancedWebProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.AdvancedWebProject.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class OrderLineDAO implements OrderLineDataAccess {
    private ProviderConverter providerConverter;
    private OrderRepository orderRepository;
    private OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLineDAO(ProviderConverter providerConverter, OrderRepository orderRepository, OrderLineRepository orderLineRepository) {
        this.providerConverter = providerConverter;
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public void saveOrderItems(ArrayList<OrderLine> items, String username) {
        OrderEntity orderEntity = orderRepository.findFirstByeMailUserOrderByIdDesc(username);
        for (OrderLine item : items) {
            orderLineRepository.save(providerConverter.orderLineModelToOrderLineEntity(item, orderEntity.getId()));
        }
    }
}
