package com.team.curingmachine.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan ({"com.team.curingmachine.*"})
@EnableMongoRepositories ("com.team.curingmachine.repo")
public class Application
{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
