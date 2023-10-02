package com.shop.dao;

import com.shop.model.User;

public abstract class UserDAO<T> {
    public abstract void addUser(T t);
    public abstract User getUserByName(String name);
}
