package com.epam.quiz.service;

import com.epam.quiz.model.Question;

import java.util.List;

public interface QuestionValidationService {
    boolean addQuestionChecker(final Question question);

    public boolean deleteQuestionChecker(final Integer questionNumber);

    public boolean updateQuestionChecker(final Integer questionNumber, final Question question);

    boolean isQuestionNumberPresentChecker(final Integer questionNumber);
    
    Question getQuestionById(Integer questionId);
    
    
    List<Question> getQuestionList();
}
