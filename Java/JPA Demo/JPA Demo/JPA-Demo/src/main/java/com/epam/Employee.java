package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * in this code we are setting the auto value to the emp id
 * that's we don't need to add the value manually
 */
@Entity
public class Employee {

    // also set the strategy
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String empName;
    private String city;

    public Employee() {
    }

    public Employee(String empName, String city) {
        this.empName = empName;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
