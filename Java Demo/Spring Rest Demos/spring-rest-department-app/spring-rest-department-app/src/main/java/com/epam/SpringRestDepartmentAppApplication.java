package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestDepartmentAppApplication {

    public static void main(String[] args) {
//		SpringApplication.run(SpringRestDepartmentAppApplication.class, args);
        SpringApplication app = new SpringApplication(SpringRestDepartmentAppApplication.class);

        // set some custom properties
        app.setLazyInitialization(true);
        app.run(args);
    }

}
