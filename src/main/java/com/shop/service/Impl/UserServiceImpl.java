package com.shop.service.Impl;

import com.shop.dao.impl.UserDAOImpl;
import com.shop.dto.UserDTO;
import com.shop.model.User;
import com.shop.repository.RoleRepository;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAOImpl userDAO;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void addUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        userDAO.addUser(user);
    }
}
