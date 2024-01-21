package com.epam.annotation_using_java_based_using_component;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* Take care here as we have a lot of college class that is why I am explicitly making bean name */
@Component("collegeBean")
public class College {
    private static final Logger LOGGER = LogManager.getLogger(College.class);

    @Autowired
    private Principal principal;

    public void sayHelloToStudent() {
        LOGGER.info("Hi Student, Welcome to BIT");
        principal.introducingPrincipal();
    }
}
