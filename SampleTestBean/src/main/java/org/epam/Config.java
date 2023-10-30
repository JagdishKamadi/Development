package org.epam;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.epam")
public class Config {

    @Bean
    @Qualifier("scienceTeacherBean")
    public ScienceTeacher getScienceTeacherBean() {
        return new ScienceTeacher();
    }
}
