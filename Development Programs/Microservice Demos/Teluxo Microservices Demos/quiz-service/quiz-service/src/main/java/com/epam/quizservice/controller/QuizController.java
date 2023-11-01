package com.epam.quizservice.controller;


import com.epam.quizservice.model.AnswerResponse;
import com.epam.quizservice.model.QuestionWrapper;
import com.epam.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<HttpStatus> createQuiz(@RequestParam String category, @RequestParam Integer numberOfQuestions, @RequestParam String title) {
        return quizService.createQuiz(category, numberOfQuestions, title);
    }

    @GetMapping("getQuiz/{title}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable String title) {
        return quizService.getQuizQuestions(title);
    }


    @PostMapping("submit/{quizTitle}")
    public ResponseEntity<Long> submitQuiz(@PathVariable String quizTitle, @RequestBody List<AnswerResponse> responses) {
        return quizService.submitQuizAndGetScore(quizTitle, responses);
    }

}
