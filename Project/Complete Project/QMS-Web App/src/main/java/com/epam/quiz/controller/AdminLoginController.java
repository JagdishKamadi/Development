package com.epam.quiz.controller;

import com.epam.quiz.dto.QuestionDTO;
import com.epam.quiz.dto.UserDTO;
import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.model.Section;
import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.UserService;
import com.epam.quiz.utility.enm.DifficultyTag;
import com.epam.quiz.utility.enm.TopicTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path="/admin")
public class AdminLoginController {
	

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/adminlogin")
	public String adminLogin(UserDTO userDTO)
	{
		userDTO.setTypeOfUser(1);
		boolean result = userService.isUserLogin(userDTO);
		
		if (!result) {
			throw new UserNotFoundException();
		}

		return "adminpages/adminpage";
	}

}
