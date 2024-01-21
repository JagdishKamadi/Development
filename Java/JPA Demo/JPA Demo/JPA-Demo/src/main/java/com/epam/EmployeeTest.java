package com.epam;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class EmployeeTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager conn = factory.createEntityManager();

        // start the transaction
        conn.getTransaction().begin();

        // it will automatically add the values
        // create the entity object
        Employee employee = new Employee("Jagdish","Pawani");

        // add the data
        conn.persist(employee);
        // commit the data
        conn.getTransaction().commit();


        // close the connection
        conn.close();
        // close the factory
        factory.close();
    }
}
