package com.example.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZipkinClientServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinClientServerApplication.class, args);
	}

}
