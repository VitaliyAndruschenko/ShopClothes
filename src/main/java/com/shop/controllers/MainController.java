package com.shop.controllers;

import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public String main(@PageableDefault(sort = {"id"},
            direction = Sort.Direction.DESC, size = 3)Pageable pageable,
                       Model model) {
        model.addAttribute("product", productService.findAll(pageable));
        return "index";
    }
}
