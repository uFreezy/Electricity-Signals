package com.example;

import com.example.data.repositories.MessageRepository;
import com.example.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Application {

	@Autowired
	private GenericApplicationContext context;


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public CommandLineRunner demo(MessageRepository repository) {
		return (args) -> {
			repository.save(new Message("Hello world"));
		};
	}

}
