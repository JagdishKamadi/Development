package com.epam.quiz.controller;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.exception.ControllerAdvisor;
import com.epam.quiz.model.User;
import com.epam.quiz.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
class UserLoginControllerTest {

	// to perform get and post request
	@Autowired
	MockMvc mockMvc;

	@MockBean
    private UserServiceImpl userService;

	@MockBean
	private SectionServiceImpl sectionService;

	@MockBean
    private QuestionServiceImpl questionService;

	@InjectMocks
	private UserLoginController userLoginController;

	@Test
	void userLoginPassTest() throws Exception {
		mockMvc.perform(get("/user/userlogin")).andExpect(status().isOk());
	}

	@Test
	void userLoginFailTest() throws Exception {
		mockMvc.perform(get("/users/userlogin")).andExpect(status().isNotFound());
	}

	@Test
	void userRegisterPassTest() throws Exception {
		mockMvc.perform(get("/user/userregister")).andExpect(status().isOk());
	}

	@Test
	void userRegisterFailTest() throws Exception {
		mockMvc.perform(get("/user/userregisters")).andExpect(status().isNotFound());
	}


	@Test
	void getUserLoginDetailsTest() throws Exception {
		when(userService.isUserLogin(any(UserDTO.class))).thenReturn(true);

		mockMvc.perform(post("/user/getlogindetails").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("username", "Jagdish").param("mailId", "jagadishkamadi@gmail.com").param("password", "Jagdish@99")
				.param("typeOfUser", "2")).andExpect(view().name("/quizpages/showquiz"));
	}

	@Test
	 void getUserRegisterDetailsPassTest() throws Exception {
		when(userService.isAddedUser(any(UserDTO.class))).thenReturn(true);
		mockMvc.perform(post("/user/getregisterdetails").contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("username", "Ayush").param("mailId", "ayush@gmail.com").param("password", "Ayush@99"))
				.andExpect(view().name("/userpages/userlogin"));
	}

	@Test
	 void getUserRegisterDetailsFailTest() throws Exception {
		when(userService.isAddedUser(any(UserDTO.class))).thenReturn(false);
		mockMvc.perform(post("/user/getregisterdetails").contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("username", "Ayush").param("mailId", "ayush@gmail.com").param("password", "Ayush@99"))
				.andExpect(view().name("/userpages/userexistpage"));
	}

	@Test
	void logoutPassTest() throws Exception {
		mockMvc.perform(get("/user/logout")).andExpect(status().isOk()).andExpect(view().name("/quizpages/logoutpage"));
	}

	@Test
	 void logoutFailTest() throws Exception {
		mockMvc.perform(get("/users/logout")).andExpect(status().isNotFound());
	}

}

/* Completed all test cases */
