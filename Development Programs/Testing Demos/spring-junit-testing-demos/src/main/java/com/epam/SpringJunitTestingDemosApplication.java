package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Ignoring @SpringBootApplication
 * we are using the 3 annotation which @SpringBootAnnotation consist of
 */

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(value = "D:\\Jagdish\\Programs\\Testing Demos\\spring-junit-testing-demos\\src\\main\\java\\com\\epam.*")
public class SpringJunitTestingDemosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJunitTestingDemosApplication.class, args);
    }

}
