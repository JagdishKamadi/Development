package com.epam.annotation_using_java_based_using_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        College college1 = context.getBean("collegeBean", College.class);
        college1.sayHelloToStudent();

        // as below bean will return the default object
        // the principal name should be null
        College college2 = context.getBean("college", College.class);
        college2.sayHelloToStudent();

        context.close();
    }
}
