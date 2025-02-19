package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan

public class SpringBootRestApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApi2Application.class, args);
	}

}
