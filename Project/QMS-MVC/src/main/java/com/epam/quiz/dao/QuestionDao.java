package com.epam.quiz.dao;

import com.epam.quiz.model.Question;

import java.util.List;
import java.util.Set;


public interface QuestionDao {
    List<Question> getAllQuestionList();
    void addNewQuestionToDB(final Question question);
    void deleteQuestionFromDB(final Integer questionNumber);
    void updateQuestionFromDB(final Integer id, Question question);
    List<Question> getCustomQuestionList(Set<Integer> questionList);
    List<Integer> getQuestionNumberListBySectionName(String sectionName);
   
}
