package com.shop.controllers;

import com.shop.dto.OrderDTO;
import com.shop.model.Product;
import com.shop.service.BasketService;
import com.shop.service.OrderService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BasketController {
    @Autowired
    private BasketService basketService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @GetMapping("/basket")
    public String getPageWithProducts(Model model) {
        model.addAttribute("products", basketService.getAllProductInBasket());
        model.addAttribute("countProduct", "Count product: ");
        model.addAttribute("totalPrice", "Price: " + basketService.getTotalPrice());
        return "basket";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        basketService.deleteProduct(product.getId());
        return "redirect:/basket";
    }

    @PostMapping("/addOrder")
    public String addOrder(@ModelAttribute OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
        orderService.addOrderProductInformation();
        basketService.clearBasket();
        return "redirect:/products";
    }

}
