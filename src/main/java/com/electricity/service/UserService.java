package com.electricity.service;

import com.electricity.model.Role;
import com.electricity.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<User> findByRoles(List<Role> roles);

    boolean any();
}
