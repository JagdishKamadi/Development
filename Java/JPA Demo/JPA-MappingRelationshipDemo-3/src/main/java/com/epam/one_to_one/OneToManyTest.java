package com.epam.one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyTest
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "mysql" );
        EntityManager em = emf.createEntityManager( );
        em.getTransaction( ).begin( );

        Student st1=new Student(1,"Tejas");
        Student st2=new Student(2,"Madhur");


        em.persist(st1);
        em.persist(st2);

        Library l1 = new Library(1,"Drilling in C",st1);
        Library l2 = new Library(2,"Deitail & Deitail in java",st2);
        em.persist(l1);
        em.persist(l2);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
