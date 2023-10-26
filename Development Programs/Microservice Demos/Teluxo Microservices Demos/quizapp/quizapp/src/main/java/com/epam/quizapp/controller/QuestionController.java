package com.epam.quizapp.controller;

import com.epam.quizapp.model.Question;
import com.epam.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Integer id) {
        return questionService.getQuestion(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> getQuestions() {
        return questionService.getQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.findByCategory(category);
    }

    @GetMapping("/category/{category}/level/{level}")
    public ResponseEntity<List<Question>> getQuestionByCategoryAndLevel(@PathVariable String category,@PathVariable String level) {
        return questionService.findByCategoryAndLevel(category,level);
    }
}
