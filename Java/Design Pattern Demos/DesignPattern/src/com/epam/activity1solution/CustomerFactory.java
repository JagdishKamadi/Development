package com.epam.activity1solution;

public class CustomerFactory {
    private static int id =-1;

    public Customer createCustomer(String name) {

        if(name == null)
            return null;

        id++;
        return new Customer(id,name);
    }

}
