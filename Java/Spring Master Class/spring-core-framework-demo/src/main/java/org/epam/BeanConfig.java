package org.epam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.epam.*;")
public class BeanConfig {

    @Bean("doctorBean")
    public Doctor DoctorBean() {
        return new Doctor(helpServiceBean());
    }

    public HelpService helpServiceBean() {
        return new HelpService();
    }
}
