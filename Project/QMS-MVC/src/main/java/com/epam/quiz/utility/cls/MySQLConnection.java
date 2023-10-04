package com.epam.quiz.utility.cls;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLConnection {

    private MySQLConnection() {
        throw new IllegalStateException("");
    }

    public static EntityManagerFactory getConnection() {
        return Persistence.createEntityManagerFactory("mysql");
    }
}
