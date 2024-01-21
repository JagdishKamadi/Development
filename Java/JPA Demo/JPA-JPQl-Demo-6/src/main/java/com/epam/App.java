package com.epam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

//        Student student1 = new Student(1,"Kunal");
//        Student student2 = new Student(2,"Shreyash");
//        manager.persist(student1);
//        manager.persist(student2);


        Query query = manager.createQuery("select s from Student s");
        List<Student> studentList = query.getResultList();

        for(Student student : studentList)
        {
            System.out.println(student.getId()+" "+ student.getName() );
        }
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
