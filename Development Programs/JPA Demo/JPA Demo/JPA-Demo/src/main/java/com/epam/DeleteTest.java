package com.epam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager conn = factory.createEntityManager();
        conn.getTransaction().begin();

        Employee e1 = conn.find(Employee.class,1);
        System.out.println(e1);
        conn.remove(e1);

        conn.getTransaction().commit();

    }
}
