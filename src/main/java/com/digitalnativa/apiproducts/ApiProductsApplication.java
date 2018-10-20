package com.digitalnativa.apiproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApiProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProductsApplication.class, args);
	}
}
