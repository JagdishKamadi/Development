package org.epam.circulardependency;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {
    public static void main(String[] args) {
        // It will give the circular dependency error
        // which is correct
        BeanFactory context = new ClassPathXmlApplicationContext("circulardependencybeanconfig.xml");
        A a = context.getBean("a", A.class);
        System.out.println(a);

    }
}
