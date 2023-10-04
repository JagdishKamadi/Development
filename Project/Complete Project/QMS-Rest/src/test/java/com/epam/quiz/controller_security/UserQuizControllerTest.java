package com.epam.quiz.controller_security;


import com.epam.quiz.controller.QuestionController;
import com.epam.quiz.converter.QuestionConverter;
import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.model.Question;
import com.epam.quiz.repository.QuestionRepository;
import com.epam.quiz.service.JwtUtil;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.SectionService;
import com.epam.quiz.utility.enm.SectionTag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class UserQuizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    @MockBean
    private SectionService sectionService;

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
    void seUpObject() throws JsonProcessingException {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails userDetails = new User("Admin", "Admin@00", authorities);
        jwt = jwtUtil.generateToken(userDetails);


    }

    @Test
    void test_startQuiz() throws Exception
    {
        String uri = "/user_quizzes/start_quiz/{section_name}";
        when(sectionService.getSectionNameNumberList(String.valueOf(SectionTag.valueOf("CORE_JAVA")))).thenReturn(Arrays.asList(1,2,3,4,5,5));
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post(uri,"CORE_JAVA")
                        .header("Authorization", "Bearer " + jwt))
                .andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    void test_getResultSuccess() throws Exception
    {
        String uri = "/user_quizzes/submit";
        when(questionService.getQuestionsBasedOnIds(Arrays.asList(3,5,7,11))).thenReturn(Arrays.asList(new Question(),new Question()));
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .header("Authorization", "Bearer " + jwt)
                        .param("3","D")
                        .param("5","C")
                        .param("7","C"))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200,status);

    }
}
