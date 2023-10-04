package com.epam.quiz.dao;

import com.epam.quiz.model.Question;

import java.util.List;

/**
 * common interface for every section
 * each type of section is going to implement this interface
 */
public interface QuizSection {
    List<Question> getAllQuestion();

    public void addNewQuestionToDB(Question question);

    List<Question> getCustomQuestionList(List<Integer> list);

    void deleteAllQuestion();

    List<Integer> getAdminQuestionList();

    void setAdminQuestionList(int questionNumber);

    List<Integer> getFinalQuestionNumberList();
    void setAllQuestion();
}
