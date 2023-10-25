package com.epam.quizapp.controller;

import com.epam.quizapp.model.Question;
import com.epam.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
}
