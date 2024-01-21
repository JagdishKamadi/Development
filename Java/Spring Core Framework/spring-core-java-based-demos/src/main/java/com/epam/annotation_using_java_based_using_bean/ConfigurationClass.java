package com.epam.annotation_using_java_based_using_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * If you want to create the bean using the bean
 * then you don't need to use the @ComponentScan annotation
 */
@Configuration
public class ConfigurationClass {

    @Bean(name = "principal")
    public Principal defaultPrincipalBean() {
        return new Principal();
    }

    @Bean
    public Principal principalBean() {  // bean name will be same as method name
        return new Principal("Mr James Bond");
    }

    @Bean(name = "college")
    public College defaultCollegeBean() {
        return new College(defaultPrincipalBean());
    }

    @Bean
    public College collegeBean() {// bean name will be same as method name
        return new College(principalBean());
    }

}
