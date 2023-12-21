package com.epam.activity1solution;

public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
       return this.name;
    }
}