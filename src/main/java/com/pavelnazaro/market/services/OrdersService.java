package com.pavelnazaro.market.services;

import com.pavelnazaro.market.entities.Order;
import com.pavelnazaro.market.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    private OrdersRepository ordersRepository;

    @Autowired
    public void setOrdersRepository(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Order saveOrder(Order order) {
        return ordersRepository.save(order);
    }
}
