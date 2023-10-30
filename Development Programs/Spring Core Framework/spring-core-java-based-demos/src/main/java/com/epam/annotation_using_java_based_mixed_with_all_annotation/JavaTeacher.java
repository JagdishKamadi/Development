package com.epam.annotation_using_java_based_mixed_with_all_annotation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class JavaTeacher implements Teacher {
    private static final Logger LOGGER = LogManager.getLogger(JavaTeacher.class);

    @Override
    public void teach() {
        LOGGER.info("I am your Java Teacher!");
    }
}
