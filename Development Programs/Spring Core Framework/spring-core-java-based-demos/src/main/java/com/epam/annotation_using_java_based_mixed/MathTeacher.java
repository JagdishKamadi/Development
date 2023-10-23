package com.epam.annotation_using_java_based_mixed;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MathTeacher implements Teacher {
    private static final Logger LOGGER = LogManager.getLogger(MathTeacher.class);
    @Value("${math.teacher.name}")
    private String mathTeacherName;


    @Override
    public void teach() {
        LOGGER.info("Hi Student I am you math teacher and my name is " + mathTeacherName);
    }
}
