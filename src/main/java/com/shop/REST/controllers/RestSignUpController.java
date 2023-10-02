package com.shop.REST.controllers;

import com.shop.dto.UserDTO;
import com.shop.model.User;
import com.shop.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/signUp")
public class RestSignUpController {
    @Autowired
    private UserService userService;
    @PostMapping("/registration")
    private ResponseEntity<User> registrationNewUser(@RequestBody UserDTO userDTO,
                                                     HttpServletResponse response) {
        if (userDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        Cookie cookie = new Cookie("username", userDTO.getUsername());
        Cookie cookie1 = new Cookie("password", userDTO.getPassword());
        response.addCookie(cookie);
        response.addCookie(cookie1);
        userService.addUser(userDTO);
        return ResponseEntity.created(null).build();
    }

}
