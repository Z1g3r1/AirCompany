package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
	@Bean
	CommandLineRunner init(FlightRepository repo) {
		return args -> {
			repo.save(new Flight(null, "SU-123", "Аэрофлот"));
			repo.save(new Flight(null, "BA-456", "S7 Airlines"));
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
