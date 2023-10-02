package com.shop.controllers;

import com.shop.model.Product;
import com.shop.service.BasketService;
import com.shop.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BasketService basketService;

    @GetMapping("/product/{id}")
    public String getProductPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("moneySign", "₽");
        return "product-detail";
    }

    @PostMapping("/addProductToBasket/{id}")
    private String addProductToBasket(@PathVariable("id") Long id,
                                      @RequestParam String countProduct, HttpServletRequest request)  {
        if (request.isUserInRole("ROLE_USER")) {
            Product product = productService.getProductById(id);
            product.setCountInBasket(countProduct);
            basketService.addProduct(product);
            return "redirect:/products";
        } else {
            return "redirect:/login";
        }
    }
}
