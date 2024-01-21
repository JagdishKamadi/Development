package com.epam.quiz_service.service;

import com.epam.quiz_service.model.AnswerResponse;
import com.epam.quiz_service.model.Question;
import com.epam.quiz_service.model.QuestionWrapper;
import com.epam.quiz_service.model.Quiz;
import com.epam.quiz_service.repository.QuestionRepository;
import com.epam.quiz_service.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        List<QuestionWrapper> transformQuestionsList = new ArrayList<>();

        quiz.getQuestions().stream()
                .forEach(q -> {
                    QuestionWrapper questionWrapper = new QuestionWrapper();
                    questionWrapper.setId(q.getId());
                    questionWrapper.setQuestionTitle(q.getQuestionTitle());
                    questionWrapper.setOption1(q.getOption1());
                    questionWrapper.setOption2(q.getOption2());
                    questionWrapper.setOption3(q.getOption3());
                    questionWrapper.setOption4(q.getOption4());
                    transformQuestionsList.add(questionWrapper);
                });

        return new ResponseEntity<>(transformQuestionsList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> submitQuizAndGetScore(Integer id, List<AnswerResponse> responses) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        List<Question> exceptedAnswerOfQuestion = quiz.getQuestions();
        Integer score = 0;
        int i = 0;

        // first of all we have tp sort the exceptedAnswerOfQuestion and responses based on id
        responses = responses.stream()
                .sorted(Comparator.comparing(AnswerResponse::getId))
                .toList();

        exceptedAnswerOfQuestion = exceptedAnswerOfQuestion.stream()
                .sorted(Comparator.comparing(Question::getId))
                .toList();

        for (AnswerResponse answerResponse : responses) {
            if (exceptedAnswerOfQuestion.get(i).getAnswer().equals(answerResponse.getAnswerOption())) {
                score++;
            }
            i++;
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
