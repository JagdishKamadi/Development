package com.epam.ui;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class GreetingClass {
    private final static Logger LOGGER = LogManager.getLogger(GreetingClass.class);
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void sayHelloToUser(String userName) {
        LOGGER.info("{}+++++++|{} Welcome {}{} |+++++++{}", ANSI_RED, ANSI_CYAN, userName, ANSI_RED,ANSI_RESET);
    }
}
