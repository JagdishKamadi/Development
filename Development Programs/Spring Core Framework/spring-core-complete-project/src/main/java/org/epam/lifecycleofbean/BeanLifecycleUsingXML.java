package org.epam.lifecycleofbean;

import org.apache.log4j.Logger;

public class BeanLifecycleUsingXML {

    private static final Logger LOGGER = Logger.getLogger(BeanLifecycleUsingXML.class);
    private String beanName;

    public BeanLifecycleUsingXML(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public String toString() {
        return "BeanLifecycleUsingXML{" +
                "beanName='" + beanName + '\'' +
                '}';
    }

    /**
     * This method will run at the time of bean creation
     * Configure in the lifecycleconfig.xml
     */
    public void init() {
        LOGGER.info("Running the at the time of creation of bean: BeanLifecycleUsingXML");
    }

    /**
     * This method will run at the last when bean will destroy
     * Configure in the lifecycleconfig.xml
     */
    public void destroy() {
        LOGGER.info("Bye bye bean is going to destroy now!: BeanLifecycleUsingXML");
    }
}
