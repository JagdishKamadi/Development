package com.epam.quiz.exception;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(String s)
    {
        super(s);
    }
}
