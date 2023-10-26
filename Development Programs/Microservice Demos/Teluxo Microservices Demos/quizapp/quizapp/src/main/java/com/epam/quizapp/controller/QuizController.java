package com.epam.quizapp.controller;

import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<HttpStatus> createQuiz(@RequestParam String category, @RequestParam Integer numberOfQuestions, @RequestParam String title) {
        return quizService.createQuiz(category, numberOfQuestions, title);
    }

    @GetMapping("getQuiz/{quizTitle}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable String quizTitle) {
        return quizService.getQuiz(quizTitle);
    }
}
