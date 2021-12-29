package com.example.emailweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EmailwebApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmailwebApplication.class, args);
	}
}
