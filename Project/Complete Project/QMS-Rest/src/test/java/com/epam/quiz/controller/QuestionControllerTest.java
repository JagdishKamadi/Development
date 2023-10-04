package com.epam.quiz.controller;

import com.epam.quiz.converter.QuestionConverter;
import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.Section;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.utility.enm.DifficultyTag;
import com.epam.quiz.utility.enm.SectionTag;
import com.epam.quiz.utility.enm.TopicTag;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private QuestionService questionService;

    @MockBean
    private QuestionRepository questionRepository;
    @InjectMocks
    private QuestionController questionController;

    @MockBean
    private QuestionConverter questionConverter;
    private QuestionDTO questionDTO;
    private Question question;
    private String questionDataJSON;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUpObject() {
        objectMapper = new ObjectMapper();
        questionDTO = new QuestionDTO();
        questionDTO.setQuestionDescription("What is Java language?");
        questionDTO.setOption1("Java is programming language");
        questionDTO.setOption2("Java is markup language");
        questionDTO.setOption3("Java is query language");
        questionDTO.setOption4("none of the above");
        questionDTO.setAnswer("A");
        questionDTO.setSectionTag(SectionTag.CORE_JAVA);
        Section section = new Section(TopicTag.JAVA_FUNDAMENTALS, DifficultyTag.EASY);
        questionDTO.setSection(section);

        question = new Question();
        question.setQuestionDescription("What is Java language?");
        question.setOption1("Java is programming language");
        question.setOption2("Java is markup language");
        question.setOption3("Java is query language");
        question.setOption4("none of the above");
        question.setAnswer("A");
        question.setSectionTag(SectionTag.CORE_JAVA);
        section = new Section(TopicTag.JAVA_FUNDAMENTALS, DifficultyTag.EASY);
        question.setSection(section);
    }

    @Test
    void test_save() throws Exception {
        String uri = "/questions";
        String dataJSON = objectMapper.writeValueAsString(questionDTO);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON).content(dataJSON).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(201, status);
    }

    @Test
    void test_getQuestionSuccess() throws Exception {
        String uri = "/questions/{questionid}";
        when(questionService.getQuestionById(anyInt())).thenReturn(questionDTO);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(uri, anyInt())).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    void test_removeSuccess() throws Exception {
        String uri = "/questions/{questionid}";
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.delete(uri, anyInt())).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
        String content = result.getResponse().getContentAsString();
        assertEquals("Question deleted successfully", content);
    }


    @Test
    void test_fetchAllQuestion() throws Exception {
        String uri = "/questions";
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        when(questionService.getAllQuestionList()).thenReturn(new ArrayList<QuestionDTO>());

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200, status);

    }


    @Test
    void test_updateSuccess() throws Exception {
        questionDTO.setQuestionId(2);
        String dataJSON = objectMapper.writeValueAsString(questionDTO);
        String uri = "/questions";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(uri).accept(MediaType.APPLICATION_JSON).content(dataJSON).contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
    }
}
