package com.epam;

import com.epam.beanpack.Car;
import com.epam.beanpack.Cycle;
import com.epam.beanpack.Tyre;
import com.epam.beanpack.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.epam.*");
        Vehicle vehicle = context.getBean("car", Car.class);
        vehicle.drive();
        System.out.println(vehicle);


    }
}
