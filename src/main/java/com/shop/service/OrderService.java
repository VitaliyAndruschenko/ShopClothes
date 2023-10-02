package com.shop.service;

import com.shop.dto.OrderDTO;
import com.shop.model.Order;

public interface OrderService {
    Order addOrder(OrderDTO orderDTO);
    void addOrderProductInformation();
}
