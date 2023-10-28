package com.epam.annotation_using_java_based_mixed_with_all_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Here are some below imp point
 * 1) we are using the @PropertySource and @PropertySources annotation so that value can be picked up from the site.properties file
 */
@Configuration
@ComponentScan(basePackages = "com.epam.annotation_using_java_based_mixed")
@PropertySource(value = "classpath:site.properties")
@PropertySources({
        @PropertySource("classpath:app.properties"),
        @PropertySource("classpath:db.properties")
})
public class ConfigurationClass {
}
