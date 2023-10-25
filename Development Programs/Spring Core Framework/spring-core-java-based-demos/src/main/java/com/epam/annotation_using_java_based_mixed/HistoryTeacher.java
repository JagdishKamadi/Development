package com.epam.annotation_using_java_based_mixed;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Here we are using the @Primary annotation
 * mean if we don't define any bean by default, this bean will be created
 */
@Component
@Primary
public class HistoryTeacher implements Teacher {
    private static final Logger LOGGER = LogManager.getLogger(HistoryTeacher.class);

    @Value("${history.teacher.name}")
    private String historyTeacherName;

    @Override
    public void teach() {
        LOGGER.info("Hi Student I am you history teacher and my name is " + historyTeacherName);
    }
}
