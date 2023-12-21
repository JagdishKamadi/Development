package com.epam.annotation_using_java_based_using_bean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Principal {
    private static final Logger LOGGER = LogManager.getLogger(Principal.class);

    private String principalName;

    public Principal() {
    }

    public Principal(String principalName) {
        this.principalName = principalName;
    }

    public void introducingPrincipal() {
        LOGGER.info("Hi Student, I am your principal and my name is " + principalName);
    }

}
