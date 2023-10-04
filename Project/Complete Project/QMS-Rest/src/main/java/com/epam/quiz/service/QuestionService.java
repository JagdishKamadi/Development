package com.epam.quiz.service;

import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.model.Question;

import java.util.List;

public interface QuestionService {
    QuestionDTO saveQuestion(QuestionDTO questionDTO);
    QuestionDTO updateQuestion(QuestionDTO questionDTO);
    QuestionDTO getQuestionById(final Integer questionId);
    List<QuestionDTO> getAllQuestionList();
    void deleteQuestion(Integer questionId);
    List<Question> getQuestionsBasedOnIds(List<Integer> questionIdList);

}
