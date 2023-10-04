package com.epam.quiz.db;
import java.util.ArrayList;
import java.util.List;

/**
 * when admin will create the quiz
 * then question number is going to store here
 */

public class AdminQuizDB {
    public static List<Integer> JavaEightQuestionList;
    public static List<Integer> advanceJavaQuestionList;
    public static List<Integer> javaEightQuestionList;

    static {
        JavaEightQuestionList = new ArrayList<>();
        advanceJavaQuestionList = new ArrayList<>();
        javaEightQuestionList   = new ArrayList<>();
    }
}
