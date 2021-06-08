package com.pruebaSpringBoot.superHeroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SuperHeroesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SuperHeroesApplication.class, args);
	}

}
