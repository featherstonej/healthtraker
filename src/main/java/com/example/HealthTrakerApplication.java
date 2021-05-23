package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.services.UserService;

@SpringBootApplication
public class HealthTrakerApplication {
	
	static UserService uServ = new UserService();
	
	public static void main(String[] args) {
		SpringApplication.run(HealthTrakerApplication.class, args);
	}

}
