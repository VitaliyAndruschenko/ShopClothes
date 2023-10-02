package com.shop.shop.controllers;

import com.nimbusds.oauth2.sdk.AuthorizationRequest;
import com.shop.shop.model.Product;
import com.shop.shop.service.BasketService;
import com.shop.shop.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.nio.file.AccessDeniedException;

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
