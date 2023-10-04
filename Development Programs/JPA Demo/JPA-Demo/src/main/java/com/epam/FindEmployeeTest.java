package com.epam;

import javax.persistence.*;

public class FindEmployeeTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager conn = factory.createEntityManager();

        // now start the transaction
        conn.getTransaction().begin();

        Employee e = conn.find(Employee.class,1);
        System.out.println(e);

        // get the all values
       Query query =  conn.createQuery("from Employee");
       System.out.println(query.getResultList());

       // to find the particular thing
        Query query1 = conn.createQuery("select e from Employee e  where empName like ?1");
        query1.setParameter(1,"J%");
        System.out.println("\nFirst Way : Custom Result Query\n"+query1.getResultList());

        Query query2 = conn.createQuery("select e from Employee e  where empName like :pattern");
        query2.setParameter("pattern","J%");
        System.out.println("\nSecond Way : Custom Result Query\n"+query2.getResultList());

        query2 = conn.createQuery("from Employee  where empName like :pattern");
        query2.setParameter("pattern","J%");
        System.out.println("\nThird Way : Custom Result Query\n"+query2.getResultList());

        conn.getTransaction().commit();
        factory.close();
    }
}
