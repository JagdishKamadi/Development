package org.epam.lifecycleofbean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifecycleUsingInterface implements InitializingBean, DisposableBean {
    private static final Logger LOGGER = Logger.getLogger(BeanLifecycleUsingInterface.class);
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }


    @Override
    public String toString() {
        return "BeanLifecycleUsingInterface{" + "beanName='" + beanName + '\'' + '}';
    }

    @Override
    public void destroy() throws Exception {
        LOGGER.info("Bye bye bean is going to destroy now!: BeanLifecycleUsingInterface");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("Running the at the time of creation of bean: BeanLifecycleUsingInterface");
    }
}
