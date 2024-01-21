package com.epam.annotation_using_java_based_using_component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);
        College college = context.getBean("collegeBean", College.class);
        college.sayHelloToStudent();
        context.close();
    }
}
