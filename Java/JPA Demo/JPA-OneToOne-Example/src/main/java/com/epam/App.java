package com.epam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Library library1 = new Library(101,"Wings of Fire");
        Library library2 = new Library(102,"Drilling in C");

        Student student1 = new Student(1,"Jagdish", library1);
        Student student2 = new Student(2,"Jayant", library2);


        manager.persist(student1);
        manager.persist(student2);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
