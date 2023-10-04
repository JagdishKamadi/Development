package com.epam.quiz.dao;

import com.epam.quiz.db.UserDataDB;
import com.epam.quiz.model.User;
import com.epam.quiz.utility.cls.MySQLConnection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserCredentialDao {

    public boolean isUserLogin(final String username, final String password) {
        List<User> userList = getUserList();
        return userList.stream().anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
    }

    public boolean registerUser(final String username, final String password) {
        List<User> userList = getUserList();
        boolean isUserExist = userList.
                stream().
                anyMatch(user -> user.getUsername().equals(username));

        if (!isUserExist) {
            EntityManager manager = MySQLConnection.getConnection();

            Query q = manager.createQuery("Select MAX(u.userId) from User u");

            Integer count = (int) q.getSingleResult();
            System.out.println("\n[-----] count [----] "+count+"\n");
            User user = new User(count+1,username,password);

            manager.persist(user);

            manager.getTransaction().commit();
            manager.close();
        }

        return isUserExist;
    }

    private List<User> getUserList() {

        EntityManager manager = MySQLConnection.getConnection();
        Query query = manager.createQuery("select u from User u");
        List<User> userList = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return userList;
    }
}
