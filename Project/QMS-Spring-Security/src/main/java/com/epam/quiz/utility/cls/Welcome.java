package com.epam.quiz.utility.cls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Welcome {

    private static final Logger logger = LogManager.getLogger(Welcome.class);
    public void helloAdmin()
    {
        logger.info("Hello Jagdish, Application has started");
    }
}
