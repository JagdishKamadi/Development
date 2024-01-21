package org.epam.lifecycleofbean;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {
    private static final Logger LOGGER = Logger.getLogger(BeanLifecycleTest.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("lifecycleconfig.xml");
        // if we want to see the destroy method then we should call the method registerShutdownHook
        context.registerShutdownHook();

        BeanLifecycleUsingXML beanLifecycleUsingXML = context.getBean("beanLifecycleUsingXML", BeanLifecycleUsingXML.class);
        LOGGER.info(beanLifecycleUsingXML);

        BeanLifecycleUsingInterface beanLifecycleUsingInterface = context.getBean("beanLifecycleUsingInterface", BeanLifecycleUsingInterface.class);
        LOGGER.info(beanLifecycleUsingXML);
    }
}
