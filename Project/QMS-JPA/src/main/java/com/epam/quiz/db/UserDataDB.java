package com.epam.quiz.db;

import com.epam.quiz.model.User;
import com.epam.quiz.utility.cls.MySQLConnection;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDataDB {

    public static List<User> userList;
    public static String username = "";


    public void addUserData() {
        EntityManager manager = MySQLConnection.getConnection();

        User user1 = new User(1,"Jagdish", "Jagdish@99");
        User user2 = new User(2,"Madhur", "Madhur@99");
        User user3 = new User(3,"Jayant", "Jayants@99");

        manager.persist(user1);
        manager.persist(user2);
        manager.persist(user3);

        manager.getTransaction().commit();
        manager.close();
    }


}
