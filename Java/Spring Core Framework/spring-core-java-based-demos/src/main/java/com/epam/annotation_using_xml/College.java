package com.epam.annotation_using_xml;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class College {
    private static final Logger LOGGER = LogManager.getLogger(College.class);

    public void sayHelloToStudent() {
        LOGGER.info("Hi Student, Welcome to BIT");
    }
}
