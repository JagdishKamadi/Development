package com.epam.quiz.controller;

import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.model.User;
import com.epam.quiz.service.QuestionValidationService;
import com.epam.quiz.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

	@Autowired
	private UserValidationService userValidationService;
	
	@Autowired
	private QuestionValidationService questionValidationService;

	@PostMapping("/adminlogin")
	public String adminLogin(User user ){
		
		user.setTypeOfUser(1);
		boolean result = userValidationService.userLoginChecker(user);
	
		if (!result) {
			throw new UserNotFoundException();
		}
		
		
		ModelAndView md = new  ModelAndView();
		md.addObject("questionlist",questionValidationService.getQuestionList());
		return "adminpages/adminpage";

	}

	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFoundHandlerException() {
		return "nullpage";
	}
}
