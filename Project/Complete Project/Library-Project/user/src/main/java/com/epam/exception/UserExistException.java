package com.epam.exception;

public class UserExistException extends RuntimeException {
    public UserExistException()
    {
        super("Username or mail id already exist!");
    }

}
