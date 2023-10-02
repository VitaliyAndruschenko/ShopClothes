package com.shop.shop.service;

import com.shop.shop.model.Product;
import com.shop.shop.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class BasketServiceTest {
    @Autowired
    BasketService basketService;
    public Product getProduct() {
        Product product = new Product("Test", "Test", 13, "Test", "Test", "13");
        product.setId(7L);
        return product;
    }
    @Test
    void addProduct() {
        basketService.addProduct(getProduct());
        assertEquals(basketService.getAllProductInBasket().size(), 1);
    }

    @Test
    void deleteProduct() {
        basketService.addProduct(getProduct());
        basketService.deleteProduct(getProduct().getId());
        assertEquals(basketService.getAllProductInBasket().size(),0);
    }
    @Test
    void clearBasket() {
        basketService.addProduct(getProduct());
        basketService.clearBasket();
        assertEquals(basketService.getAllProductInBasket().size(), 0);
    }

    @Test
    void getAllProductInBasket() {
        basketService.addProduct(getProduct());
        basketService.addProduct(getProduct());
        assertEquals(basketService.getAllProductInBasket().size(), 2);
    }

    @Test
    void getTotalPrice() {
        basketService.addProduct(getProduct());
        basketService.addProduct(getProduct());
        assertEquals(basketService.getTotalPrice(), 26);
    }
}