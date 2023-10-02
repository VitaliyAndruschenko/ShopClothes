package com.shop.shop.service;

import com.shop.model.Product;
import com.shop.service.BasketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

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