package org.epam.model;

import java.util.Arrays;

public class Car {
    private Character isCarAvailable;
    private String[] carName;

    public Car(Character isCarAvailable, String[] carName) {
        this.isCarAvailable = isCarAvailable;
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "isCarAvailable=" + isCarAvailable +
                ", carName=" + Arrays.toString(carName) +
                '}';
    }
}
