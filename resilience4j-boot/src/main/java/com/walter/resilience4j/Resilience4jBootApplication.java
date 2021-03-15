package com.walter.resilience4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Resilience4jBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Resilience4jBootApplication.class, args);
	}

}
