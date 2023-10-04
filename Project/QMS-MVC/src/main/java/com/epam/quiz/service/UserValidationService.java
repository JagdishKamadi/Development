package com.epam.quiz.service;

import com.epam.quiz.model.User;

public interface UserValidationService {
    public boolean registerUserChecker(User user);
    public boolean userLoginChecker(User user);
    public boolean isValidUserChecker(User user);
    public boolean isUserExistChecker(User user);
}
