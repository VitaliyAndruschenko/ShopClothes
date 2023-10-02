package com.shop.shop.service.Impl;

import com.shop.dao.OrderDAO;
import com.shop.dto.OrderDTO;
import com.shop.model.Order;
import com.shop.model.OrderProductInformation;
import com.shop.model.Product;
import com.shop.repository.ProductCountRepository;
import com.shop.service.BasketService;
import com.shop.service.Impl.OrderServiceImpl;
import com.shop.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class OrderServiceImplTest {
    @Autowired
    OrderService orderService;
    @Autowired
    BasketService basketService;
    @Autowired
    OrderServiceImpl orderServiceImpl;
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    ProductCountRepository productCountRepository;

    @Test
    void addOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setPhone(orderDTO.getPhone());
        orderDTO.setEmail(orderDTO.getEmail());
        orderService.addOrder(orderDTO);
        assertEquals(orderDAO.getAllOrder().size(), 1);
    }

    @Test
    void order() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setPhone(orderDTO.getPhone());
        orderDTO.setEmail(orderDTO.getEmail());
        orderService.addOrder(orderDTO);
        Order order = orderServiceImpl.order(orderDAO.getAllOrder());
        assertEquals(order.getPhone(), orderDTO.getPhone());
        assertEquals(order.getPhone(), orderDTO.getPhone());
    }
    @Test
    void addOrderProductInformation() {
        basketService.addProduct(new Product());
        basketService.addProduct(new Product());
        for (Product product : basketService.getAllProductInBasket()) {
            OrderProductInformation orderProductInformation = new OrderProductInformation();
            orderProductInformation.setCountProduct(product.getCountInBasket());
            productCountRepository.save(orderProductInformation);
        }
        assertEquals(productCountRepository.findAll().size(), 2);
        productCountRepository.deleteAll();
    }

    @Test
    void addOneOrderProductInformation() {
        OrderProductInformation orderProductInformation = new OrderProductInformation();
        orderProductInformation.setCountProduct("123");
        productCountRepository.save(orderProductInformation);
        assertEquals(productCountRepository.findAll().size(), 1);
        orderServiceImpl.addOrderProductInformation();
    }
}