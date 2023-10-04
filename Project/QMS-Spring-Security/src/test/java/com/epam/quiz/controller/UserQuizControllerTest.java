package com.epam.quiz.controller;

import com.epam.quiz.model.Question;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.SectionService;
import com.epam.quiz.utility.enm.SectionTag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class UserQuizControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private QuestionService questionService;

    @MockBean
    private SectionService sectionService;

    @InjectMocks
    private UserQuizController userQuizController;

    @Test
    void test_startQuiz() throws Exception
    {
        String uri = "/user_quizzes/start_quiz/{section_name}";
        when(sectionService.getSectionNameNumberList(String.valueOf(SectionTag.valueOf("CORE_JAVA")))).thenReturn(Arrays.asList(1,2,3,4,5,5));

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post(uri,"CORE_JAVA"))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200,status);

    }

    @Test
    void test_getResultSuccess1() throws Exception
    {
        String uri = "/user_quizzes/submit";
        when(questionService.getQuestionsBasedOnIds(Arrays.asList(3,5,7,11))).thenReturn(Arrays.asList(new Question(),new Question()));
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .param("3","D")
                        .param("5","C")
                        .param("7","C"))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    void test_getResultSuccess2() throws Exception
    {
        String uri = "/user_quizzes/submit";
        when(questionService.getQuestionsBasedOnIds(Arrays.asList(3,5,7,11))).thenReturn(Arrays.asList(new Question(),new Question()));
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post(uri))
                .andReturn();

        int status = result.getResponse().getStatus();
        assertEquals(200,status);

    }
}
