package com.ken.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// If package is outside of main method then define location using scanBasePackages to scan package.
//@SpringBootApplication(
//		scanBasePackages =  {"com.ken.app.component.scan.util",
//							 "com.ken.app.controller"}
//)
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> System.out.println("Hello World");
	}
}
