package org.epam;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Doctor doctor = context.getBean("doctorBean", Doctor.class);
        doctor.assist();
    }
}