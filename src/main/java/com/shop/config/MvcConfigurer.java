package com.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {
    @Value("${upload.path}")
    private String uploadPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/office/**")
                .addResourceLocations("file:///" + uploadPath + "/");
        registry.addResourceHandler("/product/office/**")
                .addResourceLocations("file:///" + uploadPath + "/");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/faq").setViewName("faq");
        registry.addViewController("/about").setViewName("about");
        /*главная*/
    }
}
