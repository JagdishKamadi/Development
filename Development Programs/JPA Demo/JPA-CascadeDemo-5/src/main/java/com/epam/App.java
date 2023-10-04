package com.epam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        Library l1 = new Library();
        l1.setlId(101);
        l1.setBookName("Drilling in C");

        Library l2 = new Library();
        l2.setlId(102);
        l2.setBookName("60 minute in Java");

        List<Library> libraryList = new ArrayList<>();
        libraryList.add(l1);
        libraryList.add(l2);

        Student student1 = new Student();
        student1.setStudentId(1);
        student1.setName("Jagdish");
        student1.setLibraryList(libraryList);

        // as we set cascade all, we don't need to set manually other entity object
//        manager.persist(l1);
//        manager.persist(l2);
        manager.persist(student1);

        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
