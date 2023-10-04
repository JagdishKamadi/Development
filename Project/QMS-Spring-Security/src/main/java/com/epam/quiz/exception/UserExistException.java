package com.epam.quiz.exception;

public class UserExistException extends RuntimeException{

    public UserExistException()
    {
        super("User already exist  either with mail or username!");
    }

    public UserExistException(String str)
    {
        super(str);
    }
}
