package com.epam.quizservice.service;

import com.epam.quizapp.model.AnswerResponse;
import com.epam.quizapp.model.QuestionWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    ResponseEntity<HttpStatus> createQuiz(String category, Integer numberOfQuestions, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);

    ResponseEntity<Integer> submitQuizAndGetScore(Integer id, List<AnswerResponse> responses);
}
