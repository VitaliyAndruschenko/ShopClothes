package com.shop.shop.service;

import com.shop.shop.dto.OrderDTO;
import com.shop.shop.model.Order;

public interface OrderService {
    Order addOrder(OrderDTO orderDTO);
    void addOrderProductInformation();
}
