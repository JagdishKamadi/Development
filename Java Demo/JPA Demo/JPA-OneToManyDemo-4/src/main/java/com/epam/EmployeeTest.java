package com.epam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeeTest {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Employee employee = new Employee();
        // no need to write below sentence
//        employee.setEmpId(2);
        employee.setName("Tejas");

        manager.persist(employee);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
