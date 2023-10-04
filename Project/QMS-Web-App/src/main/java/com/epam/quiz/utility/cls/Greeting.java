package com.epam.quiz.utility.cls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Greeting {

    private static final Logger logger = LogManager.getLogger(Greeting.class);

    public void sayWelcome(String name)
    {
        logger.info("Welcome {}",name);
        logger.info("Application has started succcesfully");
    }
}
