package com.epam.annotation_using_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        College college = context.getBean("college", College.class);
        college.sayHelloToStudent();
    }
}
