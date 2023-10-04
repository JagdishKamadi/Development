package com.epam.quiz.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User doesn't exist! or Please check username and password");
    }
    public UserNotFoundException(String str)
    {
        super(str);
    }
}
