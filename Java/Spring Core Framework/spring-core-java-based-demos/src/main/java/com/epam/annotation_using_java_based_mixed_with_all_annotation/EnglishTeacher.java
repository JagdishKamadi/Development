package com.epam.annotation_using_java_based_mixed_with_all_annotation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnglishTeacher implements Teacher {
    private static final Logger LOGGER = LogManager.getLogger(EnglishTeacher.class);

    @Value("${english.teacher.name:'No teacher for now'}")
    private String englishTeacherName;

    @Override
    public void teach() {
        LOGGER.info("Hi Student I am you english teacher and my name is " + englishTeacherName);
    }
}
