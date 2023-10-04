package com.epam.quiz.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("User doesn't exist!");
    }
    public UserNotFoundException(String str)
    {
        super(str);
    }
}
