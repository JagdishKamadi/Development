package com.epam.quiz.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.quiz.service.CreateQuizService;
import com.epam.quiz.service.CreateQuizServiceImpl;
import com.epam.quiz.service.QuestionValidationService;
import com.epam.quiz.service.QuestionValidationServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class UserQuizControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreateQuizServiceImpl createQuizServiceImpl;

	@MockBean
	private QuestionValidationServiceImpl questionValidationServiceImpl;

	@InjectMocks
	private UserQuizControllerTest userQuizControllerTest;

	@Test // for more than 1
	public void startQuizTest() throws Exception {
		when(questionValidationServiceImpl.getCountBySectionName(anyString())).thenReturn(2);
		mockMvc.perform(post("/userquiz/startquiz").param("sectionname", "CORE_JAVA"))
				.andExpect(view().name("/quizpages/testpage"));
	}

	@Test // for equal to 0
	public void startQuizTest2() throws Exception {
		when(questionValidationServiceImpl.getCountBySectionName(anyString())).thenReturn(0);
		mockMvc.perform(post("/userquiz/startquiz").param("sectionname", "CORE_JAVA"))
				.andExpect(view().name("/sectionpages/sectionnotfoundpage"));

	}

	@Test
	public void getResultTest() throws Exception {
		mockMvc.perform(post("/userquiz/submittest")).andExpect(view().name("/quizpages/resultpage"));
	}

}

/* Completed all test cases */