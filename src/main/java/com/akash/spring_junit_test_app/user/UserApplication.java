package com.akash.spring_junit_test_app.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		System.out.println("Main()");
		SpringApplication.run(UserApplication.class, args);
	}

}
