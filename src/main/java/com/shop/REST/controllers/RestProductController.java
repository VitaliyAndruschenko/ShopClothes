package com.shop.REST.controllers;

import com.shop.model.Product;
import com.shop.service.BasketService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1//product")
public class RestProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BasketService basketService;
    @GetMapping("/getProduct/{id}")
    private ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
    @PostMapping("/addProductInBasket/{id}")
    private ResponseEntity<Product> addProductInBasket(@PathVariable("id") Long id,
                                                       @RequestParam String countProductInBasket) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        product.setCountInBasket(countProductInBasket);
        basketService.addProduct(product);
        return ResponseEntity.ok().build();
    }
}
