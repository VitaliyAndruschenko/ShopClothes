package com.shop.controllers;

import com.shop.dto.ContactMessageDto;
import com.shop.service.ContactMessageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    @Autowired
    private ContactMessageService contactMessageService;
    @GetMapping("/contact")
    public String getPage() {
        return "contact";
    }
    @PostMapping("/addMessage")
    private String addMessage(@ModelAttribute ContactMessageDto contactMessageDto, HttpServletRequest request) {
        if (request.isUserInRole("ROLE_USER")) {
            contactMessageService.addMessage(contactMessageDto);
            return "contact";
        } else {
            return "login";
        }
    }
}
