package com.example.SpringBoog2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBoog2Application implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoog2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Step 1: Create table
		jdbcTemplate.execute("CREATE TABLE employee (id INT PRIMARY KEY, name VARCHAR(255), designation VARCHAR(255))");

		// Step 2: Insert sample data
		jdbcTemplate.update("INSERT INTO employee (id, name, designation) VALUES (?, ?, ?)", 1, "Aman", "Developer");
		jdbcTemplate.update("INSERT INTO employee (id, name, designation) VALUES (?, ?, ?)", 2, "Sahil", "Developer");

		// Step 3: Read and print data
		jdbcTemplate.query("SELECT * FROM employee", rs -> {
			System.out.println(rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getString("designation"));
		});
	}
}
