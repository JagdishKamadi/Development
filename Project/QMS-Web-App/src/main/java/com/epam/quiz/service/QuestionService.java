package com.epam.quiz.service;

import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    QuestionDTO saveQuestion(QuestionDTO questionDTO);
    QuestionDTO updateQuestion(QuestionDTO questionDTO);
    QuestionDTO getQuestionById(final Integer questionId);
    List<Question> getAllQuestionList();
    void deleteQuestion(Integer questionId);
    List<Question> getQuestionsBasedOnIds(List<Integer> questionIdList);


}
