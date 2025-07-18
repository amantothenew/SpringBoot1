package com.example.SpringBoog2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBoog2Application implements CommandLineRunner {

	//Q2 Solution
	@Value("${spring.datasource.url}")
	String H2Url;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoog2Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(H2Url);
	}

}
