package com.example.graphQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

}
