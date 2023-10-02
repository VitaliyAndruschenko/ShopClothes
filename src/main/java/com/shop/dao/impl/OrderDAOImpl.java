package com.shop.dao.impl;

import com.shop.dao.OrderDAO;
import com.shop.model.Order;
import com.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderDAOImpl extends OrderDAO {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }


}
