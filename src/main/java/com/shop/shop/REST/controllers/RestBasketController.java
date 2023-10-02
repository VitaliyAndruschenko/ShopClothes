package com.shop.shop.REST.controllers;

import com.shop.shop.dto.OrderDTO;
import com.shop.shop.model.Product;
import com.shop.shop.service.BasketService;
import com.shop.shop.service.OrderService;
import com.shop.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
public class RestBasketController {
    @Autowired
    private BasketService basketService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProductsInBasket() {
        List<Product> productList = basketService.getAllProductInBasket();
        if (productList == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productList);
    }
    @PostMapping("/addOrder")
    public ResponseEntity<Product> addProductInOrder(@RequestBody OrderDTO orderDTO) {
        if (orderDTO == null) {
            return ResponseEntity.notFound().build();
        }
        orderService.addOrder(orderDTO);
        orderService.addOrderProductInformation();
        basketService.clearBasket();
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProductInBasket(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        basketService.deleteProduct(product.getId());
        return ResponseEntity.noContent().build();
    }

}
