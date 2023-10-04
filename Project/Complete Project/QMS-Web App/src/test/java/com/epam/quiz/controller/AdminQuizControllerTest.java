package com.epam.quiz.controller;

import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.QuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(AdminQuizController.class)
class AdminQuizControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private QuestionServiceImpl questionService;

	@InjectMocks
	private AdminQuizController adminQuizController;

	@Test
	void quizOperationTest() throws Exception {
		mockMvc.perform(get("/adminquiz/operation")
						.param("optionchoice", "1"))
						.andExpect(view().name("updatequiz/addnewquestion"));
	}
};