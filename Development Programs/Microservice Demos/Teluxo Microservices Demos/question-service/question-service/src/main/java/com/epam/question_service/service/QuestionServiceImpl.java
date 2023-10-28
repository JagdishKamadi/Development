package com.epam.quizapp.service;

import com.epam.quizapp.model.Question;
import com.epam.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public ResponseEntity<Question> saveQuestion(Question question) {
        return new ResponseEntity<>(questionRepository.save(question), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Question>> saveQuestions(List<Question> questions) {
        return new ResponseEntity<>(questionRepository.saveAll(questions), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Question> getQuestion(Integer id) {
        return new ResponseEntity<>(questionRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Question>> getQuestions() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Question>> findByCategory(String category) {
        return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Question>> findByCategoryAndLevel(String category, String level) {
        return new ResponseEntity<>(questionRepository.findByCategoryAndLevel(category, level), HttpStatus.OK);
    }
}
