package com.shop.dao;

import com.shop.model.Order;

import java.util.List;

public abstract class OrderDAO {
    public abstract void addOrder(Order order);
    public abstract List<Order> getAllOrder();
}
