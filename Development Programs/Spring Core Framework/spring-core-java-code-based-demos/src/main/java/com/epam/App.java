package com.epam;

import com.epam.beanpack.ConfigClass;
import com.epam.beanpack.Doctor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
        Doctor doctor = context.getBean(Doctor.class);
        doctor.assist();
    }
}
