package com.epam.annotation_using_java_based_mixed;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class College {
    private static final Logger LOGGER = LogManager.getLogger(College.class);

    @Value("BIT")
    private String collegeName;

    public void sayHelloToStudent() {
        LOGGER.info("Hi Student, Welcome to the " + collegeName);
    }
}
