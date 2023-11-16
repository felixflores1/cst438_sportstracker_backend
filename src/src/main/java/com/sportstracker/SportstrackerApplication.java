package com.sportstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = "com.sportstracker")


@SpringBootApplication
public class SportstrackerApplication {  

	public static void main(String[] args) {
		SpringApplication.run(SportstrackerApplication.class, args);
	}

}
