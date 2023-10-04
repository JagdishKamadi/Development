package com.epam.quiz.service;

import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question saveQuestion(QuestionDTO questionDTO);
    boolean isQuestionDeleted(Integer questionId);
    boolean isQuestionUpdated(QuestionDTO questionDTO);
    Optional<Question> getQuestionById(final Integer questionId);
    List<Question> getAllQuestionList();
    boolean isQuestionExist(final Integer questionId);

    List<Question> getCustomQuestionList(List<Integer> questionIdList);

}
