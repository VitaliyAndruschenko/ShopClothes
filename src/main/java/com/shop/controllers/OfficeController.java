package com.shop.controllers;

import com.shop.dto.ProductDTO;
import com.shop.model.Product;
import com.shop.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class OfficeController {
    @Autowired
    public ProductService productService;
    @ModelAttribute("product")
    public Page<Product> getListProduct() {
        return productService.findAll(Pageable.ofSize(4));
    }
    @GetMapping("/office")
    public String office(HttpServletRequest request) {
        return "office";
    }
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String productName,
                             @RequestParam String tagline,
                             @RequestParam Integer price,
                             @RequestParam String description,
                             @RequestParam MultipartFile photoFileName,
                             ProductDTO productDTO) throws IOException {
        Product product = productDTO.addProduct(productName, tagline, price, description, photoFileName);
        productService.addProduct(product, photoFileName);
        return "redirect:office";
    }
    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam String productName) {
        productService.deleteProduct(productName);
        return "redirect:office";
    }
    @GetMapping("/findProduct")
    public String findProductByProductName(@RequestParam String productName, Model model) {
        List<Product> productList = productService.findByProductName(productName);
        model.addAttribute("production", productList);
        return "/office";
    }
    @PostMapping("/updateProduct")
    public String updateProduct(ProductDTO product, @RequestParam("photoFileName") MultipartFile photoFileName) throws IOException {
        productService.updateProduct(product, photoFileName);
        return "redirect:office";
    }
}
