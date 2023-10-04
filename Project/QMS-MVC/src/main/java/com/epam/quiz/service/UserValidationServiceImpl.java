package com.epam.quiz.service;

import com.epam.quiz.dao.UserDao;
import com.epam.quiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationServiceImpl implements UserValidationService {
    @Autowired
    private UserDao userDaoImpl;

    @Override
    public boolean registerUserChecker(User user) {

        boolean result = false;
        if (isValidUserChecker(user) && !isUserExistChecker(user)) {
            userDaoImpl.addUserToDb(user);
            result = true;
        }

        return result;
    }

    @Override
    public boolean userLoginChecker(User user) {
        return userDaoImpl.getUserList().stream().anyMatch(user1 -> user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword()) );
    }

    @Override
    public boolean isValidUserChecker(User user) {
        return user.getUsername().length() >= 5 && user.getMailId().length() >= 13 && user.getPassword().length() >= 5;
    }

    @Override
    public boolean isUserExistChecker(User user) {
        return userDaoImpl.getUserList().stream().anyMatch(user1 -> user1.getUsername().equals(user.getUsername()) || user1.getMailId().equals(user.getMailId()));
    }

}
