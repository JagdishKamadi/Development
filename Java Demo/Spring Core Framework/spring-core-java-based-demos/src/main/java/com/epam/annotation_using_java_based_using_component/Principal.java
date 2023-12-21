package com.epam.annotation_using_java_based_using_component;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Principal {
    private static final Logger LOGGER = LogManager.getLogger(Principal.class);

    public void introducingPrincipal() {
        LOGGER.info("Hi Student, I am your principal");
    }

}
