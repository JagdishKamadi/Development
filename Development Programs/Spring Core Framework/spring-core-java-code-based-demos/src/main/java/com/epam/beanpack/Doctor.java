package com.epam.beanpack;

import org.springframework.stereotype.Component;


@Component
public class Doctor {

    public void assist() {
        System.out.println("I am doctor and I am helping the patient ");
    }
}
