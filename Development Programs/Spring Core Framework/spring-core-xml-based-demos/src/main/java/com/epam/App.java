package com.epam;

import com.epam.beanpack.Car;
import com.epam.beanpack.Cycle;
import com.epam.beanpack.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Vehicle vehicle = context.getBean("cycle", Cycle.class);
        vehicle.drive();
    }
}
