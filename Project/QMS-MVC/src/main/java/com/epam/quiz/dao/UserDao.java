package com.epam.quiz.dao;

import com.epam.quiz.model.User;
import java.util.List;

public interface UserDao {
    List<User> getUserList();
    void addUserToDb(User user);
}
