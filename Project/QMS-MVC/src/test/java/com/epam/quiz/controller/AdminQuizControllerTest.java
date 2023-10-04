package com.epam.quiz.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.quiz.service.CreateQuizServiceImpl;
import com.epam.quiz.service.UserValidationService;

@SpringBootTest
@AutoConfigureMockMvc
class AdminQuizControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreateQuizServiceImpl createQuizServiceImpl;

	@Autowired
	private SectionTagList sectionTagList;

	@InjectMocks
	private AdminQuizController adminQuizController;

	@Test
	public void quizOperationTest() throws Exception {

		mockMvc.perform(get("/adminquiz/operation").param("optionchoice", "1"))
				.andExpect(view().name("updatequiz/addnewquestion"));
	}
};