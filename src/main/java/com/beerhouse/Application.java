package com.beerhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@ComponentScan(basePackages = "com.beerhouse")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}