package com.epam.quizapp.service;

import com.epam.quizapp.model.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    ResponseEntity<Question> getQuestion(Integer id);

    ResponseEntity<List<Question>> getQuestions();

    ResponseEntity<List<Question>> findByCategory(String category);

    ResponseEntity<List<Question>> findByCategoryAndLevel(String category, String level);
}
