package com.example.ordini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrdiniApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdiniApplication.class, args);
	}

}
