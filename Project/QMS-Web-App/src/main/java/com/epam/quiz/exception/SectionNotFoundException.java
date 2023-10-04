package com.epam.quiz.exception;

public class SectionNotFoundException extends RuntimeException{
    public SectionNotFoundException()
    {
        super("Currently we don't have the question of these section!\n please attend the another section");
    }

    public SectionNotFoundException (String str)
    {
        super(str);
    }
}
