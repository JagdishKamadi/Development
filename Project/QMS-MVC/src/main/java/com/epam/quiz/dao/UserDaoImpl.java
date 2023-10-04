package com.epam.quiz.dao;

import com.epam.quiz.model.User;
import com.epam.quiz.utility.cls.MySQLConnection;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getUserList() {
        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        manager.clear();

        Query query = manager.createQuery("Select u from User u");
        List<User> userList = query.getResultList();
        manager.close();
        return userList;
    }

    @Override
    public void addUserToDb(User user) {
    
        EntityManager manager = MySQLConnection.getConnection().createEntityManager();
        manager.clear();
        manager.getTransaction().begin();
        user.setTypeOfUser(2);
        
        
        manager.persist(user);

        manager.getTransaction().commit();
        manager.close();

    }
}
