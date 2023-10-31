package com.epam.questionservice.controller;

import com.epam.questionservice.model.AnswerResponse;
import com.epam.questionservice.model.Question;
import com.epam.questionservice.model.QuestionWrapper;
import com.epam.questionservice.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "question")
@Slf4j
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // This is to get the environment variables
    @Autowired
    private Environment environment;

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

    @PostMapping("create")
    public ResponseEntity<List<Integer>> generateQuestionForQuiz(@RequestParam String category, @RequestParam Integer numberOfQuestions) {
        return questionService.generateQuestionForQuiz(category, numberOfQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> questionsId) {
        // if we are running on multiple port then we are checking on which port we are running the service
        log.info("Port Number {}", environment.getProperty("local.server.port"));
        return questionService.getQuestionsById(questionsId);
    }

    @PostMapping("getScore")
    public ResponseEntity<Long> getScore(@RequestBody List<AnswerResponse> responses) {
        return questionService.getScore(responses);
    }
}
