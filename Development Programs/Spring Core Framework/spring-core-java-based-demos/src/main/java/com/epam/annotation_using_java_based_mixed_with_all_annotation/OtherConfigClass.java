package com.epam.annotation_using_java_based_mixed_with_all_annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherConfigClass {

    @Bean
    @Qualifier("scienceTeacher")
    public Teacher getScienceTeacherBean() {
        return new ScienceTeacher();
    }
}
