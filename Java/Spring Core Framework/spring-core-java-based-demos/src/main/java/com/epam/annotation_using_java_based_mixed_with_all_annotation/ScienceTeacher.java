package com.epam.annotation_using_java_based_mixed_with_all_annotation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScienceTeacher implements Teacher {
    private static final Logger LOGGER = LogManager.getLogger(ScienceTeacher.class);

    @Value("${science.teacher.name}")
    private String scienceTeacherName;

    @Override
    public void teach() {
        LOGGER.info("Hi Student I am you science teacher and my name is " + scienceTeacherName);
    }
}
