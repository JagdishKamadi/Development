package com.epam.exception;

public class UserExistException extends RuntimeException{
    public UserExistException() {
        super("Already User exist for this username!");
    }

    public UserExistException(String message) {
        super(message);
    }
}
