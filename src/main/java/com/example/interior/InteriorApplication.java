package com.example.interior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class InteriorApplication {
	public static void main(String[] args) {
		SpringApplication.run(InteriorApplication.class, args);
	}

}
