package com.epam.annotation_using_java_based_using_bean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class College {
    private static final Logger LOGGER = LogManager.getLogger(com.epam.annotation_using_xml.College.class);

    public void sayHelloToStudent() {
        LOGGER.info("Hi Student, Welcome to BIT");
    }
}
