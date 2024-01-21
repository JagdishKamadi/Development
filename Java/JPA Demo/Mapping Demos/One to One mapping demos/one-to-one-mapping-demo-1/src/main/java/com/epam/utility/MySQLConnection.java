package com.epam.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLConnection {

    public synchronized static EntityManagerFactory getConnection()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        return factory;
    }
}
