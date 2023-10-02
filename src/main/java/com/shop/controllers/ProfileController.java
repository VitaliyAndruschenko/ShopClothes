package com.shop.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
    @RequestMapping("/profile")
    public String getProfilePage(@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter,
                                 HttpServletResponse httpServletResponse, Model model) {
        hitCounter++;
        Cookie foo = new Cookie("hitCounter", hitCounter.toString());
        model.addAttribute("cookie", hitCounter.toString());
        foo.setMaxAge(1000);
        httpServletResponse.addCookie(foo);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("user", username);
        return "profile";
    }
}
