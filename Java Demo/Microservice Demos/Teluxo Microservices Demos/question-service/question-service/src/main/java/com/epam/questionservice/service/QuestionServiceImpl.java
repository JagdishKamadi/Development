package com.epam.questionservice.service;

import com.epam.questionservice.model.AnswerResponse;
import com.epam.questionservice.model.Question;
import com.epam.questionservice.model.QuestionWrapper;
import com.epam.questionservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Question>> getQuestionsByCategoryAndLevel(String category, String level) {
        return new ResponseEntity<>(questionRepository.findByCategoryAndLevel(category, level), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Integer>> generateQuestionForQuiz(String category, Integer numberOfQuestions) {
        return new ResponseEntity<>(questionRepository.findRandomQuestionByCategory(category, numberOfQuestions), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Integer> questionsId) {
        // convert the question to QuestionWrapper here
        List<QuestionWrapper> questionWrapperList = questionRepository.findAllById(questionsId).stream()
                .map(QuestionWrapper::new)
                .toList();

        return new ResponseEntity<>(questionWrapperList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> getScore(List<AnswerResponse> responses) {

        // get the question first using the id
        List<Question> listOfAllQuestions = questionRepository.findAllById(responses.stream().map(r -> r.getId()).toList());
        // map each question id with answer
        Map<Integer, String> questionIdWithAnswerMap = listOfAllQuestions.stream()
                .collect(Collectors.toMap(Question::getId, Question::getAnswer));

        Long score = responses.stream().filter(r -> questionIdWithAnswerMap.containsKey(r.getId()) && r.getAnswerOption().equals(questionIdWithAnswerMap.get(r.getId()))).count();

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
