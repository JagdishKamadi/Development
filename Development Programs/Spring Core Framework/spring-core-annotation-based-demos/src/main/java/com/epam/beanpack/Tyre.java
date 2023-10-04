package com.epam.beanpack;

import org.springframework.stereotype.Component;

@Component
public class Tyre {
    public String brand;

    @Override
    public String toString() {
        return "Tyre{" +
                "brand='" + "MRF" + '\'' +
                '}';
    }
}
