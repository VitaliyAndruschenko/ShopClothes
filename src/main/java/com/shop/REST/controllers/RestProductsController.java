package com.shop.REST.controllers;

import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class RestProductsController {
    @Autowired
    private ProductService productService;
    @GetMapping("/getProducts")
    private ResponseEntity<Page<Product>> getProductsPage(Pageable pageable) {
        Page<Product> products = productService.findAll(pageable);
        if (products == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }
}
