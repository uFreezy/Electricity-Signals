package com.electricity.utils;

import com.electricity.data.repositories.RoleRepository;
import com.electricity.model.Role;
import com.electricity.model.User;
import com.electricity.service.UserService;

import java.util.HashSet;

public class Seeder {


    private static void roleSeed(RoleRepository repo) {
        if (repo.count() > 0) return;

        Role userRole = new Role();
        userRole.setName("User");
        Role serviceRole = new Role();
        serviceRole.setName("Service");
        Role directorRole = new Role();
        directorRole.setName("Director");

        repo.save(userRole);
        repo.save(serviceRole);
        repo.save(directorRole);

    }

    private static void userSeed(UserService service) {
        User usr = new User();
        usr.setUsername("123456");
        usr.setPassword("12345678");
        usr.setRoles(new HashSet<>());
        service.save(usr);
    }


    public static void run(RoleRepository roleRepository, UserService userService) {

        Seeder.roleSeed(roleRepository);
        Seeder.userSeed(userService);
    }
}
