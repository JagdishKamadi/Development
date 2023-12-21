package com.epam.quiz.db;

import com.epam.quiz.model.User;
import com.epam.quiz.utility.cls.MySQLConnection;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDataDB {
    public static void addUserData() {
        EntityManager manager = MySQLConnection.getConnection();
        manager.clear();
        manager.getTransaction().begin();

        User user1 = new User("Jagdish","jagadishkamadi@gmail.com", "Jagdish@99");
        User user2 = new User("Madhur", "madhyabhoyar@gmail.com","Madhur@99");
        User user3 = new User("Jayant", "jayantawari@gmail.com","Jayants@99");
        User user4 = new User("Admin", "admin@gmail.com","Admin@00");

        manager.persist(user4);
        manager.persist(user1);
        manager.persist(user2);
        manager.persist(user3);

        manager.getTransaction().commit();
        manager.close();
    }


}
