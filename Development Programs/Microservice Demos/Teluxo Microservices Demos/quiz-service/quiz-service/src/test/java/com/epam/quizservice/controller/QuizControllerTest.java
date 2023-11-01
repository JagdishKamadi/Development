package com.epam.quizservice.controller;

import com.epam.quizservice.feign.QuestionService;
import com.epam.quizservice.model.AnswerResponse;
import com.epam.quizservice.model.QuestionWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * As we are doing the testing for the microservice
 * so we have to do testing for feign client class or service firstly
 * that is why we have to mock the feign client first and then do the testing
 */
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class QuizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // mock the feign client
    @MockBean
    private QuestionService questionService;

    private static ObjectMapper objectMapper;
    private static String category;
    private static Integer numberOfQuestions;
    private static String title;

    private static List<AnswerResponse> responseList;

    private static List<Integer> questionIdList;
    private static List<QuestionWrapper> questionWrapperList;
    private static String responseListStringDataJson;

    @BeforeAll
    static void setUp() throws Exception {
        objectMapper = new ObjectMapper();
        category = "Java";
        numberOfQuestions = 5;
        title = "MyFirstSpringQuiz";

        AnswerResponse response = AnswerResponse.builder()
                .id(1)
                .answerOption("A")
                .build();

        responseList = new ArrayList<>();
        responseList.add(response);

        questionIdList = new ArrayList<>();
        questionWrapperList = new ArrayList<>();
        responseListStringDataJson = objectMapper.writeValueAsString(responseList);

    }

    @Test
    void createQuizTest() throws Exception {
        // Test the feign client class method first
        when(questionService.generateQuestionForQuiz(category, numberOfQuestions)).thenReturn(new ResponseEntity<>(questionIdList, HttpStatus.OK));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/quiz/create")
                        .param("category", category)
                        .param("numberOfQuestions", String.valueOf(numberOfQuestions))
                        .param("title", title))
                .andReturn();

        assertEquals(201, result.getResponse().getStatus());
    }


    @Test
    void getQuizTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/quiz/getQuiz/{title}", title))
                .andExpect(status().isOk());
    }

    @Test
    void submitQuizTest() throws Exception {
        Long score = 2l;
        when(questionService.getScore(responseList))
                .thenReturn(new ResponseEntity<>(score, HttpStatus.OK));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/quiz/submit/{quizTitle}", title)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(responseListStringDataJson))
                .andExpect(status().isOk()) // status should be 200
                .andReturn();

        // score should be 2
        assertEquals(score, Long.parseLong(result.getResponse().getContentAsString()));
    }
}