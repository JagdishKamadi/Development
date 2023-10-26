package com.epam.quizapp.controller;

import com.epam.quizapp.model.Question;
import com.epam.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = {"save/question"})
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }

    @PostMapping(value = {"save/questions"})
    public ResponseEntity<List<Question>> saveQuestions(@RequestBody List<Question> questions) {
        return questionService.saveQuestions(questions);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteQuestion(@PathVariable Integer id) {
        return questionService.deleteQuestion(id);
    }

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
    public ResponseEntity<List<Question>> getQuestionByCategoryAndLevel(@PathVariable String category, @PathVariable String level) {
        return questionService.findByCategoryAndLevel(category, level);
    }
}
