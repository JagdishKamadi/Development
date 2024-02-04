package org.epam;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("config.xml");
        Doctor doctor = context.getBean("doctor", Doctor.class);
        doctor.assist();
    }
}