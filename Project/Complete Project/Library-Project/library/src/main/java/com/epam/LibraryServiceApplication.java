package com.epam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class LibraryServiceApplication {

	private static final Logger logger = LogManager.getLogger(LibraryServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
		logger.info("Welcome Jagdish LibraryServiceApplication has started on port 8084");
	}

}
