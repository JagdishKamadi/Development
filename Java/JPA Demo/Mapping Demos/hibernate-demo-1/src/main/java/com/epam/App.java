package com.epam;


import com.epam.util.MySQLConnection;

import javax.persistence.EntityManager;

public class App
{
    public static void main( String[] args )
    {
        EntityManager em = MySQLConnection.getConnection();
        System.out.println(".....running");
    }
}
