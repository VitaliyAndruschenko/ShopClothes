package com.shop.service.Impl;

import com.shop.model.Product;
import com.shop.service.BasketService;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
@Data
public class BasketServiceImpl implements BasketService {
    private List<Product> products = new ArrayList<>();
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }
    @Override
    public Product deleteProduct(Long id) {
        Product product = new Product();
        for (Product product1 : products) {
            if (product1.getId().equals(id)) {
                product = product1;
            }
        }
        products.remove(product);
        return product;
    }
    @Override
    public void clearBasket() {
        products.clear();
    }
    @Override
    public List<Product> getAllProductInBasket() {
        return getProducts();
    }
    @Override
    public Integer getTotalPrice() {
        Integer totalPrice = 0;
        for (Product product : getAllProductInBasket()) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
