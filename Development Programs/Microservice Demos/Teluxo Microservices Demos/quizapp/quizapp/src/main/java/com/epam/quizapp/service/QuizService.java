package com.epam.quizapp.service;

import com.epam.quizapp.model.Quiz;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface QuizService {
    ResponseEntity<HttpStatus> createQuiz(String category, Integer numberOfQuestions, String title);

    ResponseEntity<Quiz> getQuiz(String quizTitle);
}
