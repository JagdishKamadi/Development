package com.interf.fun;

import java.util.Comparator;

public class Employee
{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString()
    {
        return "Employee{Name : "+this.name+", Age "+this.age+"}\n";
    }
}
