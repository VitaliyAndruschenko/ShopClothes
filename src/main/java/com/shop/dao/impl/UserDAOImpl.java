package com.shop.dao.impl;

import com.shop.dao.UserDAO;
import com.shop.model.User;
import com.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends UserDAO<User> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByUsername(name);
    }
}
