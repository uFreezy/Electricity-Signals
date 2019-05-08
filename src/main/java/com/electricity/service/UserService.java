package com.electricity.service;

import com.electricity.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
