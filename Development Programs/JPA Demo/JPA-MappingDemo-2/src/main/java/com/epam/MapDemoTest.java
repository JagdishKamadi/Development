package com.epam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MapDemoTest
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Address address1 = new Address("Pawani","442304");
        Employee employee1 = new Employee();
        employee1.setEmpId(1);
        employee1.setName("Jagdish");
        employee1.getAddressList().add(address1);

        Address address2 = new Address("Wardha","442001");
        Employee employee2 = new Employee();
        employee2.setEmpId(2);
        employee2.setName("Madhur");
        employee2.getAddressList().add(address2);

        manager.persist(employee1);
        manager.persist(employee2);

        manager.getTransaction().commit();
        manager.close();
        factory.close();

    }
}
