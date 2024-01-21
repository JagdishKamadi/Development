package org.epam.annotation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This package shows the Autowiring using the XML configuration
 *
 * @author Jagdish Kamadi
 */

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotationbasedconfig.xml");
        Teacher teacher = context.getBean("teacher", Teacher.class);
        LOGGER.info(teacher);
        Teacher teacher2 = context.getBean("teacher2", Teacher.class);
        LOGGER.info(teacher2);
    }
}
