package com.epam.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLConnection {

    public static EntityManager getConnection()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        return factory.createEntityManager();
    }

}
