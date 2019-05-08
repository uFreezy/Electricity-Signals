package com.electricity.service;

import com.electricity.model.Role;

public interface RoleService {
    void save(Role role);

    Role findByName(String roleName);
}
