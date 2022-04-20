package com.plg.springvalidationexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringValidationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringValidationExampleApplication.class, args);
		System.out.println("abcdeF".substring(0, 1).toUpperCase() + "abcdeF".substring(1).toLowerCase());
	}

}
