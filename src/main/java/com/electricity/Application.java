package com.electricity;

import com.electricity.data.repositories.RoleRepository;
import com.electricity.service.UserService;
import com.electricity.utils.Seeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner seedRunner(RoleRepository roleRepo, UserService userService) {
        return (args) -> Seeder.run(roleRepo, userService);
    }
}
