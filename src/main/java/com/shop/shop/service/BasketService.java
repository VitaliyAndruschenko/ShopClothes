package com.shop.shop.service;

import com.shop.shop.model.Product;

import java.util.List;

public interface BasketService {
    void addProduct(Product product);
    Product deleteProduct(Long id);
    void clearBasket();
    List<Product> getAllProductInBasket();
    Integer getTotalPrice();
}
