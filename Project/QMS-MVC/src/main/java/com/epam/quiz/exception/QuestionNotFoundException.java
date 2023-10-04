package com.epam.quiz.exception;

public class QuestionNotFoundException extends RuntimeException{
    public QuestionNotFoundException()
    {
        super("Question doesn't exist");
    }
    public QuestionNotFoundException(String str)
    {
        super(str);
    }
}
