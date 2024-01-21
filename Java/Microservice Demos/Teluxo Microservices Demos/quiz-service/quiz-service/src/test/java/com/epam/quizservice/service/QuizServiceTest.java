package com.epam.quizservice.service;

import com.epam.quizservice.feign.QuestionService;
import com.epam.quizservice.model.AnswerResponse;
import com.epam.quizservice.model.QuestionWrapper;
import com.epam.quizservice.model.Quiz;
import com.epam.quizservice.repository.QuizRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuizServiceTest {

    @Mock
    private QuizRepository quizRepository;

    @Mock
    private QuestionService questionService;
    @InjectMocks
    private QuizServiceImpl quizService;

    private static Quiz quiz;
    private static List<Integer> questionIdsList;
    private static QuestionWrapper questionWrapper;
    private static List<QuestionWrapper> questionWrapperList;
    private static String category;
    private static Integer numberOfQuestions;
    private static String title;


    @BeforeAll
    static void setUpObjects() {
        questionWrapper = new QuestionWrapper();
        questionWrapperList = new ArrayList<>();
        questionWrapper.setId(1);
        questionWrapper.setQuestionTitle("Question");
        questionWrapper.setOption1("A");
        questionWrapper.setOption2("B");
        questionWrapper.setOption3("C");
        questionWrapper.setOption4("D");
        questionWrapperList.add(questionWrapper);

        questionIdsList = new ArrayList<>();
        category = "Java";
        numberOfQuestions = 5;
        title = "MySpringQuiz";
        quiz = Quiz.builder()
                .id(1)
                .category(category)
                .questionsIds(questionIdsList).build();
    }

    @Test
    void createQuizTest() throws Exception {
        // Mock the behavior of the questionService
        when(questionService.generateQuestionForQuiz(category, numberOfQuestions))
                .thenReturn(new ResponseEntity<>(questionIdsList, HttpStatus.OK));
        // Test the createQuiz method
        ResponseEntity<HttpStatus> result = quizService.createQuiz(category, numberOfQuestions, title);
        verify(quizRepository, times(1)).save(any(Quiz.class));
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void getQuizQuestionsTest() throws Exception {
        when(quizRepository.findByQuizTitle(title)).thenReturn(quiz);
        when(questionService.getQuestionsById(questionIdsList)).thenReturn(new ResponseEntity<>(questionWrapperList, HttpStatus.OK));
        assertEquals(questionWrapperList, quizService.getQuizQuestions(title).getBody());
    }

    @Test
    void submitQuizAndGetScoreTest() throws Exception {
        AnswerResponse response = AnswerResponse.builder()
                .id(1)
                .answerOption("A")
                .build();
        List<AnswerResponse> responseList = List.of(response);

        Long score = 2L;
        when(questionService.getScore(responseList)).thenReturn(new ResponseEntity<>(score, HttpStatus.OK));
        ResponseEntity responseEntity = quizService.submitQuizAndGetScore(title, responseList);
        assertEquals(200, responseEntity.getStatusCode().value());
        assertEquals(score, responseEntity.getBody());
    }

    @Test
    public void SubmitQuizAndGetScoreTest2() throws Exception {
        AnswerResponse response = AnswerResponse.builder()
                .id(1)
                .answerOption("A")
                .build();
        List<AnswerResponse> responseList = List.of(response);

        Long score = 2L;
        when(questionService.getScore(responseList))
                .thenReturn(new ResponseEntity<>(score, HttpStatus.OK));

        // Test the submitQuizAndGetScore method
        ResponseEntity<Long> result = quizService.submitQuizAndGetScore(title, responseList);

        // Verify that the score is calculated and the HTTP status is HttpStatus.OK
        verify(questionService).getScore(responseList);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(score, result.getBody());
    }
}