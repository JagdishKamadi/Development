package com.epam.JpaDemo;
import javax.persistence.*;


public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-local-mysql");
        EntityManager em = emf.createEntityManager();
        
        Employee e1 = new Employee(2,"Jagdish");
        em.getTransaction().begin();
        em.persist(e1);
    
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
