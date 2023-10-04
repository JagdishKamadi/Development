package com.epam.beanpack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.epam.beanpack")
public class ConfigClass {

    @Bean
    public Doctor getDoctor() {
        return new Doctor();
    }
}
