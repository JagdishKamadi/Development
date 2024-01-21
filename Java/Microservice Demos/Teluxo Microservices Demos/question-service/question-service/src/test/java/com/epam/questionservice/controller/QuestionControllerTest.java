package com.epam.questionservice.controller;

import com.epam.questionservice.model.AnswerResponse;
import com.epam.questionservice.model.Question;
import com.epam.questionservice.utility.enm.Category;
import com.epam.questionservice.utility.enm.Level;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    private static Question question;
    private static List<Question> questionList;

    private static String questionStringDataJSON;
    private static String questionsStringDataJSON;

    @BeforeAll
    static void setupObject() throws Exception {
        question = new Question();
        questionList = new ArrayList<>();
        question.setQuestionTitle("Who invented Java Programming?");
        question.setOption1("Guido van Rossum");
        question.setOption2("James Gosling");
        question.setOption3("Dennis Ritchie");
        question.setOption4("Bjarne Stroustrup");
        question.setAnswer("James Gosling");
        question.setLevel(Level.EASY.getLevel());
        question.setCategory(Category.JAVA.getCategory());
        questionList.add(question);
        objectMapper = new ObjectMapper();
        questionStringDataJSON = objectMapper.writeValueAsString(question);
        questionsStringDataJSON = objectMapper.writeValueAsString(questionList);
        log.info("Json value of question : {}", questionStringDataJSON);
    }

    @Test
    void saveQuestionTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/question/save/question")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(questionStringDataJSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists()); // Assuming the response contains an "id" field
    }

    @Test
    void saveQuestionsTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/question/save/questions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(questionsStringDataJSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(201, result.getResponse().getStatus());
    }

    @Test
    void deleteQuestionTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/question/{id}", anyInt()))
                .andExpect(status().isOk());
    }

    @Test
    void getQuestionTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/question/{id}", anyInt()))
                .andExpect(status().isOk());
    }

    @Test
    void getQuestionsTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/question/"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void getQuestionByCategoryTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/question/category/Java"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void getQuestionByCategoryAndLevelTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/question/category/Java/level/Easy"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void getQuestionByCategoryAndLevelTest2() throws Exception {
        String cat = anyString();
        String lev = anyString();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/question/category/cat/level/lev"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void generateQuestionForQuizTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/question/create")
                        .param("category", anyString())
                        .param("numberOfQuestions", String.valueOf(anyInt())))
                .andExpect(status().isCreated());
    }

    @Test
    void getQuestionsByIdTest() throws Exception {
        List<Integer> questionsIdList = new ArrayList<>();
        questionsIdList.add(1);
        questionsIdList.add(2);
        questionsIdList.add(3);
        String questionsIdStringDataJSON = objectMapper.writeValueAsString(questionsIdList);

        mockMvc.perform(MockMvcRequestBuilders.post("/question/getQuestions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(questionsIdStringDataJSON))
                .andExpect(status().isOk());
    }

    @Test
    void getScoreTest() throws Exception {

        List<AnswerResponse> responses = new ArrayList<>();
        AnswerResponse answerResponse = AnswerResponse.builder()
                .id(1)
                .answerOption("Option 1")
                .build();
        responses.add(answerResponse);
        String responsesStringDataJSON = objectMapper.writeValueAsString(responses);

        mockMvc.perform(MockMvcRequestBuilders.post("/question/getScore")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(responsesStringDataJSON))
                .andExpect(status().isOk());
    }
}