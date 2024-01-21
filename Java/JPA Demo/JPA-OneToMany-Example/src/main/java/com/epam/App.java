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

        Student student = new Student();
        student.setStudentId(1);
        student.setName("Jagdish");

        Library library1 = new Library();
        library1.setLibraryId(101);
        library1.setBookName("Wings of Fire");
        library1.setStudent(student);

        Library library2 = new Library();
        library2.setLibraryId(102);
        library2.setBookName("Drilling in C");
        library2.setStudent(student);

        List<Library> libraryList = new ArrayList<>();
        libraryList.add(library1);
        libraryList.add(library2);

        student.setLibraryList(libraryList);

        manager.persist(student);

        manager.getTransaction().commit();
        manager.close();
        factory.close();

    }
}
