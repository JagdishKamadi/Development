package com.epam.activity1solution;
public class CustomerFactoryPatternTest {
    public static void main(String[] args) {

        CustomerFactory customerFactory1 = new CustomerFactory();
        Customer customer1 = customerFactory1.createCustomer("Jagdish");
        System.out.println(customer1.getId()+" "+customer1.getName());

        CustomerFactory customerFactory2 = new CustomerFactory();
        Customer customer2 = customerFactory2.createCustomer("Madhur");
        System.out.println(customer2.getId()+" "+customer2.getName());

        CustomerFactory customerFactory3 = new CustomerFactory();
        Customer customer3 = customerFactory3.createCustomer("Jayant");
        System.out.println(customer3.getId()+" "+customer3.getName());

    }
}
