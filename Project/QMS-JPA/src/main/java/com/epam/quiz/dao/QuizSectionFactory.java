package com.epam.quiz.dao;

/**
 * to generate the instance of the every section
 * we are using the QuizSectionFactory
 * even in the worst condition it is not going to receive the null
 *
 */

public class QuizSectionFactory {
    public static QuizSection getInstance(final Integer typeOfSection)
    {
        if(typeOfSection==1)
            return new CoreJavaQuestionDao();
        else if(typeOfSection==2)
            return new AdvanceJavaQuestionDao();
        else if(typeOfSection==3)
            return new JavaEightQuestionDao();

        return null;
    }
}
