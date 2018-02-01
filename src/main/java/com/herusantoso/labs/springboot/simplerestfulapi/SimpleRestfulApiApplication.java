package com.herusantoso.labs.springboot.simplerestfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleRestfulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestfulApiApplication.class, args);
	}
}
