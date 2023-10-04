package com.epam.quiz.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.epam.quiz.model.User;
import com.epam.quiz.service.SectionValidationService;
import com.epam.quiz.service.UserValidationService;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;

@WebMvcTest(UserLoginController.class)
class UserLoginControllerTest {

	// to perform get and post request
	@Autowired
	MockMvc mockMvc;

	@MockBean
	private UserValidationService userValidationService;

	@MockBean
	private SectionValidationService sectionValidationServiceImpl;

	@InjectMocks
	private UserLoginController userLoginController;

	@Test
	void userLoginTest() throws Exception {
		mockMvc.perform(get("/user/userlogin")).andExpect(status().isOk());
	}

	@Test
	void userRegisterTest() throws Exception {
		mockMvc.perform(get("/user/userregister")).andExpect(status().isOk());
	}

	@Test
	public void getUserLoginDetailsTest() throws Exception {
		User user = new User("Jagdish", "jagadishkamadi@gmail.com", "Jagdish@99", 2);
		when(userValidationService.userLoginChecker(user)).thenReturn(true);

		mockMvc.perform(post("/user/getregisterdetails").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("username", "Jagdish").param("mailId", "agadishkamadi@gmail.com").param("password", "Jagdish@99")
				.param("typeOfUser", "2")).andExpect(view().name("/userpages/userlogin"));
	}

	@Test
	public void getUserRegisterDetailsTest() throws Exception {
		mockMvc.perform(post("/user/getregisterdetails").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("username", "Ayush").param("mailId", "ayush@gmail.com").param("password", "Ayush@99"))
				.andExpect(view().name("/userpages/userlogin"));
	}

	@Test
	public void logoutTest() throws Exception {
		mockMvc.perform(get("/user/logout")).andExpect(status().isOk()).andExpect(view().name("/quizpages/logoutpage"));
	}

}

/* Completed all test cases */
