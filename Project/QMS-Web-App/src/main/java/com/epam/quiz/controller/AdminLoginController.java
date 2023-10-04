package com.epam.quiz.controller;

import com.epam.quiz.service.QuestionService;
import com.epam.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/admin")
public class AdminLoginController {
	

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/login")

	public ModelAndView adminLogin()
	{
		ModelAndView md = new ModelAndView();
		md.addObject("questions",questionService.getAllQuestionList());
		md.setViewName("updatequiz/quizupdatepage");
		return md;
	}

}
