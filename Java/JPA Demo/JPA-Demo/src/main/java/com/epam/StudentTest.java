package com.epam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();

        Student s1 = new Student(2, "Harshal", "Borgaon");
        manager.getTransaction().begin();

        // now add the data
        manager.persist(s1);
        // now commit the data
        manager.getTransaction().commit();

        // close the connection
        manager.close();
        factory.close();


    }
}
