package com.demo.deepanshu.dao;

import com.demo.deepanshu.model.User;

public interface UserDAO {
    User getUserById(int userId);
    void addUser(User user);
}
