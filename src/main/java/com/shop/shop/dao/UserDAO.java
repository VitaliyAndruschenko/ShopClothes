package com.shop.shop.dao;

import com.shop.shop.model.User;

public abstract class UserDAO<T> {
    public abstract void addUser(T t);
    public abstract User getUserByName(String name);
}
