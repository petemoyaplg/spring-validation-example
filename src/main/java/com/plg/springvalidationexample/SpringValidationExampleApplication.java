package com.plg.springvalidationexample;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringValidationExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringValidationExampleApplication.class, args);
	}

	@Scheduled(fixedDelay = 2000)
	public void sheduledRun() {
		System.out.println("Currentr sheduled time : " + new Date());
	}

}
