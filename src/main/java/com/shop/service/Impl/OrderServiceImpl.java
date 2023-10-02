package com.shop.service.Impl;

import com.shop.dao.OrderDAO;
import com.shop.dto.OrderDTO;
import com.shop.model.Order;
import com.shop.model.Product;
import com.shop.model.OrderProductInformation;
import com.shop.repository.ProductCountRepository;
import com.shop.service.BasketService;
import com.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private BasketService basketService;
    private List<Order> orderList = new ArrayList<>();
    @Autowired
    private ProductCountRepository productCountRepository;
    @Override
    public Order addOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setPhone(orderDTO.getPhone());
        order.setEmail(orderDTO.getEmail());
        order.setLocalDate(LocalDate.now());
        order.setTotalPrice(basketService.getTotalPrice());
        orderDAO.addOrder(order);
        orderList.add(order);
        return order;
    }
    public Order order(List<Order> orders) {
        Order order = new Order();
        for (Order order1 : orders) {
            order = order1;
        }
        return order;
    }
    public void addOrderProductInformation() {
        for (Product product : basketService.getAllProductInBasket()) {
            OrderProductInformation orderProductInformation = new OrderProductInformation();
            orderProductInformation.setOrder(order(orderList));
            orderProductInformation.setCountProduct(product.getCountInBasket());
            orderProductInformation.setProduct(product);
            productCountRepository.save(orderProductInformation);
        }
    }
}
