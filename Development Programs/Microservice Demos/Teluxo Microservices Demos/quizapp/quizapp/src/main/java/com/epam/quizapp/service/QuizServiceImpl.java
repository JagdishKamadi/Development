package com.epam.quizapp.service;

import com.epam.quizapp.model.Question;
import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.repository.QuestionRepository;
import com.epam.quizapp.repository.QuizRepository;
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
    private QuestionRepository questionRepository;

    @Override
    public ResponseEntity<HttpStatus> createQuiz(String category, Integer numberOfQuestions, String title) {
        List<Question> questions = questionRepository.findRandomQuestionByCategory(category, numberOfQuestions);
        Quiz quiz = Quiz.builder()
                .quizTitle(title)
                .questions(questions).build();

        quizRepository.save(quiz);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Quiz> getQuiz(String quizTitle) {
        return new ResponseEntity<>(quizRepository.findByQuizTitle(quizTitle), HttpStatus.OK);
    }
}
