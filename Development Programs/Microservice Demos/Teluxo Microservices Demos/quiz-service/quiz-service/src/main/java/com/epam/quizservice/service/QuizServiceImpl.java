package com.epam.quizservice.service;


import com.epam.quizservice.feign.QuestionService;
import com.epam.quizservice.model.AnswerResponse;
import com.epam.quizservice.model.QuestionWrapper;
import com.epam.quizservice.model.Quiz;
import com.epam.quizservice.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Eager
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionService questionService;


    @Override
    public ResponseEntity<HttpStatus> createQuiz(String category, Integer numberOfQuestions, String title) {
        List<Integer> questionIdsList = questionService.generateQuestionForQuiz(category, numberOfQuestions).getBody();
        Quiz quiz = Quiz.builder()
                .category(category)
                .quizTitle(title)
                .questionsIds(questionIdsList)
                .build();

        quizRepository.save(quiz);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(String title) {
        Quiz quiz = quizRepository.findByQuizTitle(title);
        return questionService.getQuestionsById(quiz.getQuestionsIds());
    }

    @Override
    public ResponseEntity<Long> submitQuizAndGetScore(String quizTitle, List<AnswerResponse> responses) {
        return questionService.getScore(responses);
    }


}
