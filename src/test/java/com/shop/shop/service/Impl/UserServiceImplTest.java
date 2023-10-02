package com.shop.shop.service.Impl;

import com.shop.shop.dao.UserDAO;
import com.shop.shop.dto.UserDTO;
import com.shop.shop.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class UserServiceImplTest {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserDAO userDAO;
    @Test
    void addUser() {
        UserDTO userDTO = new UserDTO("John", "Anderson", "123");
        userService.addUser(userDTO);
        User user = userDAO.getUserByName(userDTO.getUsername());
        assertEquals(user.getUsername(), userDTO.getUsername());
        assertEquals(user.getEmail(), userDTO.getEmail());
        assertEquals(user.getPassword(), userDTO.getPassword());
    }
}