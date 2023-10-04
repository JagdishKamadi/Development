package com.epam.beanpack;

import org.springframework.stereotype.Component;

@Component
public class Cycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("I am riding the Bycycle");
    }
}
