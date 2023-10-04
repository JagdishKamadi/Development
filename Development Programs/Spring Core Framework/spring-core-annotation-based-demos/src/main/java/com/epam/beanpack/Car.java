package com.epam.beanpack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    @Autowired
    private Tyre tyre;

    @Override
    public void drive() {
        System.out.println("I am driving the car");
    }

    @Override
    public String toString() {
        return "Car{" +
                "tyre=" + tyre +
                '}';
    }
}
