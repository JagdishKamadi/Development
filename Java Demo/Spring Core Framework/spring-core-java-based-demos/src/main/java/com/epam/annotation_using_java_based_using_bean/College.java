package com.epam.annotation_using_java_based_using_bean;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * If you want to create the bean using the bean
 * then you don't need to use the @Component annotation
 */
public class College {
    private static final Logger LOGGER = LogManager.getLogger(College.class);
    private Principal principal;

    public College() {
    }

    public College(Principal principal) {
        this.principal = principal;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }

    public void sayHelloToStudent() {
        LOGGER.info("Hi Student, Welcome to BIT");
        principal.introducingPrincipal();
    }
}
