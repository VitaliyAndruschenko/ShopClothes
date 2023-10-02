package com.shop.controllers;

import com.shop.dto.UserDTO;
import com.shop.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/sign-up")
    public String getPage() {
        return "sign-up";
    }
    @PostMapping("/sign-up")
    public String registrationUser(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String email,
                                   HttpServletResponse response) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(encoder.encode(password));
        userDTO.setEmail(email);
        Cookie cookie = new Cookie("username", username);
        Cookie cookie1 = new Cookie("password", password);
        response.addCookie(cookie);
        response.addCookie(cookie1);
        userService.addUser(userDTO);
        return "redirect:/login";
    }
}
