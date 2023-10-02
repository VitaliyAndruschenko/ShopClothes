package com.shop.shop.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void main() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print())
                .andExpect(view().name("index"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string(containsString("Cool Fashion")));
    }
}