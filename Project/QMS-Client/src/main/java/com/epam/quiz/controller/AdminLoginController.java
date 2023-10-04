package com.epam.quiz.controller;

import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping(path="/admin")
public class AdminLoginController {
	

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;

	private WebClient webClient;

	@PostConstruct
	public void init() {
		webClient = WebClient.builder().baseUrl("http://localhost:9090/admin")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}


	@PostMapping("/login")
	public String adminLogin(UserDTO userDTO)
	{
		userDTO.setTypeOfUser(1);
		boolean result = userService.isUserLogin(userDTO);
		
		if (!result) {
			throw new UserNotFoundException();
		}
		webClient.post().uri("/").bodyValue(userDTO).retrieve().bodyToMono(String.class).block();
		return "adminpages/adminpage";
	}

}
