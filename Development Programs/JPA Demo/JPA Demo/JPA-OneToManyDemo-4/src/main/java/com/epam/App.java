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

        Library library1 = new Library(105,"Wings of Fire");
        Library library2 = new Library(106,"Seduction is Art");

        manager.persist(library1);
        manager.persist(library2);

        List<Library>  libraryList  = new ArrayList<>();

        libraryList.add(library1);
        libraryList.add(library2);

        Student student = new Student();
        student.setId(3);
        student.setName("Kunal");
        student.setLibraries(libraryList);

        manager.persist(student);



        manager.getTransaction().commit();
        manager.close();
        factory.close();

    }
}
