package com.epam.quizservice.service;

import com.epam.quizservice.model.AnswerResponse;
import com.epam.quizservice.model.QuestionWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<HttpStatus> createQuiz(String category, Integer numberOfQuestions, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(String title);

    ResponseEntity<Long> submitQuizAndGetScore(String quizTitle, List<AnswerResponse> responses);
}
