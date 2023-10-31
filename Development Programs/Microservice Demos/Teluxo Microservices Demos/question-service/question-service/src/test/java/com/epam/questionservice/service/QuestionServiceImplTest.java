package com.epam.questionservice.service;

import com.epam.questionservice.model.AnswerResponse;
import com.epam.questionservice.model.Question;
import com.epam.questionservice.model.QuestionWrapper;
import com.epam.questionservice.repository.QuestionRepository;
import com.epam.questionservice.utility.enm.Category;
import com.epam.questionservice.utility.enm.Level;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionService;

    private static Question question;
    private static List<Question> questionList;

    @BeforeAll
    public static void beforeAll() {
        question = new Question();
        question.setId(1);
        question.setQuestionTitle("Who invented Java Programming?");
        question.setOption1("Guido van Rossum");
        question.setOption2("James Gosling");
        question.setOption3("Dennis Ritchie");
        question.setOption4("Bjarne Stroustrup");
        question.setAnswer("James Gosling");
        question.setLevel(Level.EASY.getLevel());
        question.setCategory(Category.JAVA.getCategory());
        questionList = new ArrayList<>();
        questionList.add(question);
    }

    @Test
    void saveQuestionTest() {
        when(questionRepository.save(question)).thenReturn(question);
        assertEquals(HttpStatus.CREATED, questionService.saveQuestion(question).getStatusCode());
        assertEquals(question, questionService.saveQuestion(question).getBody());
    }

    @Test
    void saveQuestionsTest() {
        questionList.add(question);
        when(questionRepository.saveAll(questionList)).thenReturn(questionList);
        assertEquals(HttpStatus.CREATED, questionService.saveQuestions(questionList).getStatusCode());
        assertEquals(questionList, questionService.saveQuestions(questionList).getBody());
    }

    @Test
    void deleteQuestionTest() {
        questionRepository.deleteById(anyInt());
        verify(questionRepository).deleteById(anyInt());
        verify(questionRepository, times(1)).deleteById(anyInt());
        assertEquals(HttpStatus.OK, questionService.deleteQuestion(anyInt()).getStatusCode());
    }

    @Test
    void getQuestionIfExistTest() {
        when(questionRepository.findById(anyInt())).thenReturn(Optional.of(question));
        assertAll("Checking all possible cases",
                () -> assertNotNull(questionService.getQuestion(anyInt()).getBody()),
                () -> assertEquals(HttpStatus.OK, questionService.getQuestion(anyInt()).getStatusCode()));
    }

    @Test
    @DisplayName(value = "If question id does not exist then it should return the null")
    void getQuestionIfNotExistTest() {
        when(questionRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertAll("Checking all possible cases",
                () -> assertNull(questionService.getQuestion(anyInt()).getBody()),
                () -> assertEquals(HttpStatus.OK, questionService.getQuestion(anyInt()).getStatusCode()));
    }

    @Test
    void getQuestionsTest() {
        when(questionRepository.findAll()).thenReturn(questionList);

        assertAll("Checking all possible cases",
                () -> assertNotNull(questionService.getQuestions()),
                () -> assertEquals(questionList, questionService.getQuestions().getBody()),
                () -> assertEquals(HttpStatus.OK, questionService.getQuestions().getStatusCode()));
    }

    @Test
    void getQuestionsByCategoryTest() {
        String category = anyString();
        when(questionRepository.findByCategory(category)).thenReturn(questionList);
        assertAll("Checking all possible cases",
                () -> assertNotNull(questionService.getQuestionsByCategory(category)),
                () -> assertEquals(questionList, questionService.getQuestionsByCategory(category).getBody()),
                () -> assertEquals(HttpStatus.OK, questionService.getQuestionsByCategory(category).getStatusCode()));
    }

    @Test
    void getQuestionsByCategoryTest2() {
        String category = anyString();
        when(questionRepository.findByCategory(category)).thenReturn(questionList);
        ResponseEntity<List<Question>> result = questionService.getQuestionsByCategory(category);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(questionList, result.getBody());
        assertEquals(questionList.get(0).getId(), result.getBody().get(0).getId());
    }

    @Test
    void getQuestionsByCategoryAndLevelTest() {
        String category = anyString();
        String level = anyString();
        when(questionRepository.findByCategoryAndLevel(category, level)).thenReturn(questionList);
        assertAll("Checking all possible cases",
                () -> assertNotNull(questionService.getQuestionsByCategoryAndLevel(category, level)),
                () -> assertEquals(questionList, questionService.getQuestionsByCategoryAndLevel(category, level).getBody()),
                () -> assertEquals(HttpStatus.OK, questionService.getQuestionsByCategoryAndLevel(category, level).getStatusCode()));
    }

    @Test
    void generateQuestionForQuizTest() {
        List<Integer> questionsId = new ArrayList<>();
        questionsId.add(1);
        String category = anyString();
        Integer numberOfQuestions = anyInt();
        when(questionRepository.findRandomQuestionByCategory(category, numberOfQuestions)).thenReturn(questionsId);
        assertAll("Checking all possible cases",
                () -> assertNotNull(questionService.generateQuestionForQuiz(category, numberOfQuestions)),
                () -> assertEquals(questionsId, questionService.generateQuestionForQuiz(category, numberOfQuestions).getBody()),
                () -> assertEquals(HttpStatus.CREATED, questionService.generateQuestionForQuiz(category, numberOfQuestions).getStatusCode()));
    }

    @Test
    void getQuestionsByIdTest() {
        List<Integer> questionsId = new ArrayList<>();
        questionsId.add(1);
        when(questionRepository.findAllById(questionsId)).thenReturn(questionList);
        assertAll("Checking all possible cases",
                () -> assertNotNull(questionService.getQuestionsById(questionsId)),
                () -> assertEquals(questionsId.get(0), questionService.getQuestionsById(questionsId).getBody().get(0).getId()));
    }

    @Test
    public void getQuestionsByIdTest2() {
        // Create a list of question IDs for testing
        List<Integer> questionIds = Arrays.asList(1, 2, 3);

        // Create a list of Question objects to be returned by the mock questionRepository
        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestionTitle("Question 1");
        q1.setAnswer("A");

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestionTitle("Question 2");
        q2.setAnswer("B");

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestionTitle("Question 3");
        q3.setAnswer("C");

        List<Question> questions = Arrays.asList(q1, q2, q3);

        // Define the behavior of the questionRepository mock
        when(questionRepository.findAllById(questionIds)).thenReturn(questions);

        // Call the method to be tested
        ResponseEntity<List<QuestionWrapper>> result = questionService.getQuestionsById(questionIds);

        // Assert the result
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(3, result.getBody().size()); // Assuming 3 questions were found
        // You can add more specific assertions if needed, e.g., to verify the content of QuestionWrapper objects in the result.
    }

    @Test
    void getScoreTest() {
        // Create a list of AnswerResponse objects for testing
        AnswerResponse response1 = new AnswerResponse(1, "A");
        AnswerResponse response2 = new AnswerResponse(2, "B");
        AnswerResponse response3 = new AnswerResponse(3, "C");
        List<AnswerResponse> responses = Arrays.asList(response1, response2, response3);

        // Create a list of Question objects to be returned by the mock questionRepository
        Question q1 = new Question();
        q1.setId(1);
        q1.setQuestionTitle("Question 1");
        q1.setAnswer("A");

        Question q2 = new Question();
        q2.setId(2);
        q2.setQuestionTitle("Question 2");
        q2.setAnswer("B");

        Question q3 = new Question();
        q3.setId(3);
        q3.setQuestionTitle("Question 3");
        q3.setAnswer("C");

        List<Question> questions = Arrays.asList(q1, q2, q3);

        // Define the behavior of the questionRepository mock
        when(questionRepository.findAllById(Arrays.asList(1, 2, 3))).thenReturn(questions);

        // Call the method to be tested
        ResponseEntity<Long> result = questionService.getScore(responses);

        // Assert the result
        assertEquals(HttpStatus.OK, result.getStatusCode());
        // if all the answer are correct then score should be 3
        assertEquals(Long.valueOf(3), result.getBody());
        // if one of the answer miss the then score should be less than 3
        assertNotEquals(Long.valueOf(2), result.getBody());
    }
}