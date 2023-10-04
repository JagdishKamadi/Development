package com.epam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookServiceApplication {
	private static final Logger logger = LogManager.getLogger(BookServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
		logger.info("Welcome Jagdish book-service started at port-number 8080");
	}

}
