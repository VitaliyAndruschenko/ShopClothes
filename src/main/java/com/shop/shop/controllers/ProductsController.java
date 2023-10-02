package com.shop.shop.controllers;

import com.shop.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    private String getProductsPage(@PageableDefault(sort = {"id"},
            direction = Sort.Direction.ASC, size = 3)Pageable pageable,
                                   Model model) {
        model.addAttribute("product", productService.findAll(pageable));
        model.addAttribute("maxPage", productService.findAll(pageable).getSize());
        return "products";
    }
}
