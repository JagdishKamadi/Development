package com.epam.annotation_using_java_based_mixed_with_all_annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/**
 * Here are some below imp point
 * 1) we are using the @PropertySource and @PropertySources annotation so that value can be picked up from the site.properties file
 */
@Configuration
@ComponentScan(basePackages = "com.epam.annotation_using_java_based_mixed_with_all_annotation")
@PropertySource(value = "classpath:site.properties")
@PropertySources({
        @PropertySource("classpath:app.properties"),
        @PropertySource("classpath:db.properties")
})
@Import(value = OtherConfigClass.class)
public class ConfigurationClass {

    /**
     * Below is the example with
     *
     * @Bean
     * @Autowired both of mixture configuration
     */
    @Bean
    @Qualifier("scienceTeacherBean")
    public Teacher getJavaTeacherBean() {
        return new JavaTeacher();
    }
}
