package com.epam.quiz.controller_security;

import com.epam.quiz.controller.QuestionController;
import com.epam.quiz.converter.QuestionConverter;
import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.Section;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.service.JwtUtil;
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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
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

    @Autowired
    private JwtUtil jwtUtil;

    private String jwt;

    @BeforeEach
    void setUpObject() throws Exception {
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

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails userDetails = new User("Admin", "Admin@00", authorities);
        jwt = jwtUtil.generateToken(userDetails);

        questionDataJSON = objectMapper.writeValueAsString(questionDTO);
    }


    @Test
    void test_getQuestions() throws Exception {
        List<QuestionDTO> questions = new ArrayList<>();
        when(questionService.getAllQuestionList()).thenReturn(questions);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/questions")
                .header("Authorization", "Bearer " + jwt)
                .contentType(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(requestBuilder).andExpect(status().isOk());

    }

    @Test
    void test_getQuestionSuccess() throws Exception {

        when(questionService.getQuestionById(anyInt())).thenReturn(new QuestionDTO());

        RequestBuilder builder = MockMvcRequestBuilders.get("/questions/1")
                .header("Authorization", "Bearer " + jwt)
                .contentType(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    void test_getQuestionError() throws Exception {

        when(questionService.getQuestionById(anyInt())).thenThrow(new QuestionNotFoundException());

        RequestBuilder builder = MockMvcRequestBuilders.get("/questions/1")
                .header("Authorization", "Bearer " + jwt)
                .contentType(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(builder).andExpect(status().isBadRequest());
    }

    @Test
    void test_save() throws Exception
    {
        when(questionService.saveQuestion(any(QuestionDTO.class))).thenReturn(questionDTO);
        RequestBuilder builder = MockMvcRequestBuilders.post("/questions")
                .header("Authorization", "Bearer " + jwt)
                .content(questionDataJSON)
                .contentType(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(builder).andExpect(status().isCreated());
    }

    @Test
    void test_update() throws Exception
    {
        when(questionService.saveQuestion(any(QuestionDTO.class))).thenReturn(questionDTO);
        RequestBuilder builder = MockMvcRequestBuilders.put("/questions")
                .header("Authorization", "Bearer " + jwt)
                .content(questionDataJSON)
                .contentType(MediaType.APPLICATION_JSON);
        this.mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    void test_deleteSuccess() throws Exception {

        MvcResult result = this.mockMvc.perform(delete("/questions/1").header("Authorization", "Bearer " + jwt))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        verify(questionService, times(1)).deleteQuestion(anyInt());

    }

}
