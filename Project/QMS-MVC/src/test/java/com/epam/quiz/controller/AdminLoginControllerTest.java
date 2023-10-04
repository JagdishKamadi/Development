package com.epam.quiz.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.quiz.model.User;
import com.epam.quiz.service.CreateQuizServiceImpl;
import com.epam.quiz.service.QuestionValidationService;
import com.epam.quiz.service.QuestionValidationServiceImpl;
import com.epam.quiz.service.SectionValidationServiceImpl;
import com.epam.quiz.service.UserValidationService;
import com.epam.quiz.service.UserValidationServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class AdminLoginControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserValidationServiceImpl userValidationService;

	@MockBean
	private QuestionValidationServiceImpl questionValidationService;

	@InjectMocks
	private AdminLoginControllerTest admin;

	@Test
	public void adminLoginTest() throws Exception {
//		User user = new User("Admin","admin@gamil.com","Admin@00",1);
		when(userValidationService.userLoginChecker(any(User.class))).thenReturn(true);
		
		mockMvc.perform(post("/admin/adminlogin")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("username", "Admin")
				.param("mailId", "admin@gmail.com")
				.param("password", "Admin@0"))
		        .andExpect(view().name("adminpages/adminpage"));
	}
	
	
}
/* Completed all test cases */
