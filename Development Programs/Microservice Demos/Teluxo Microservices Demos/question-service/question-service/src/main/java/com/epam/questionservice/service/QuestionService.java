package com.epam.questionservice.service;

import com.epam.questionservice.model.AnswerResponse;
import com.epam.questionservice.model.Question;
import com.epam.questionservice.model.QuestionWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    ResponseEntity<Question> saveQuestion(Question question);

    ResponseEntity<List<Question>> saveQuestions(List<Question> questions);

    ResponseEntity<HttpStatus> deleteQuestion(Integer id);

    ResponseEntity<Question> getQuestion(Integer id);

    ResponseEntity<List<Question>> getQuestions();


    ResponseEntity<List<Question>> findByCategory(String category);

    ResponseEntity<List<Question>> findByCategoryAndLevel(String category, String level);

    ResponseEntity<List<Integer>> generateQuestionForQuiz(String category, Integer numberOfQuestions);

    ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Integer> questionsId);

    ResponseEntity<Long> getScore(List<AnswerResponse> responses);
}
