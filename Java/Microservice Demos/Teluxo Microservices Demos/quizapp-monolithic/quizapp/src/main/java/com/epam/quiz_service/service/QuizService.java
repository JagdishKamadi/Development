package com.epam.quiz_service.service;

import com.epam.quiz_service.model.AnswerResponse;
import com.epam.quiz_service.model.QuestionWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<HttpStatus> createQuiz(String category, Integer numberOfQuestions, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);

    ResponseEntity<Integer> submitQuizAndGetScore(Integer id, List<AnswerResponse> responses);
}
