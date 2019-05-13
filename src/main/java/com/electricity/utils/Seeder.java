package com.electricity.utils;

import com.electricity.data.repositories.RoleRepository;
import com.electricity.model.Role;
import com.electricity.model.Signal;
import com.electricity.model.User;
import com.electricity.service.SignalService;
import com.electricity.service.UserService;

import java.util.Collections;
import java.util.Date;

public class Seeder {

    private static void roleSeed(RoleRepository repo) {
        if (repo.count() > 0) return;

        Role userRole = new Role("User");
        Role serviceRole = new Role("Service");
        Role directorRole = new Role("Director");

        repo.save(userRole);
        repo.save(serviceRole);
        repo.save(directorRole);
    }

    private static void userSeed(UserService service, RoleRepository roleRepo) {
        User usr = new User("Ivan", "Petrov", "123456", "12345678", "12345678");
        service.save(usr);

        User serviceUser = new User("Service", "Service", "service", "service", "service");
        serviceUser.setRoles(Collections.singleton(roleRepo.findByName("Service")));
        service.save(serviceUser);

        User director = new User("Director", "Director", "director", "director", "director");
        director.setRoles(Collections.singleton(roleRepo.findByName("Director")));
        service.save(director);
    }


    private static void signalSeed(UserService userService, SignalService signalService) {

        for (int i = 1; i <= 50; i++) {
            boolean isCompleted = i % 2 == 0;
            Date completedOn = null;
            if (isCompleted) completedOn = new Date();
            Signal signal = new Signal("Sample Street" + i, "My electricity is not working", new Date(), isCompleted, completedOn, userService.findByUsername("123456"));

            signalService.save(signal);
        }

    }

    public static void run(RoleRepository roleRepository, UserService userService, SignalService signalService) {
        if (roleRepository.count() == 0)
            Seeder.roleSeed(roleRepository);
        if (!userService.any())
            Seeder.userSeed(userService, roleRepository);
        if (!signalService.any())
            Seeder.signalSeed(userService, signalService);
    }
}
