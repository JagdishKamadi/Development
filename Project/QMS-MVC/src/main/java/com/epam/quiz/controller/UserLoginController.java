package com.epam.quiz.controller;

import com.epam.quiz.exception.UserNotFoundException;
import com.epam.quiz.model.User;
import com.epam.quiz.service.SectionValidationService;
import com.epam.quiz.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserLoginController {

	@Autowired
	private UserValidationService userValidationService;

	@Autowired
	private SectionValidationService sectionValidationServiceImpl;

	@RequestMapping(path = "/userlogin")
	public String userLogin() {
		return "userpages/userlogin";
	}

	@GetMapping("/userregister")
	public String userRegister() {
		return "userpages/register";
	}

	@PostMapping("/getlogindetails")
	public ModelAndView getUserLoginDetails(@ModelAttribute User user) {
		user.setTypeOfUser(2);
		boolean result = userValidationService.userLoginChecker(user);

		if (!result) {
			throw new UserNotFoundException();
		}

		ModelAndView md = new ModelAndView();

		md.addObject("sectionlist", sectionValidationServiceImpl.getSectionList().values());
		md.setViewName("/quizpages/showquiz");

		return md;
	}

	@PostMapping("/getregisterdetails")
	public String getUserRegisterDetails(@ModelAttribute() User user) {
		user.setTypeOfUser(2);

		boolean result = userValidationService.registerUserChecker(user);

		System.out.println("Result : " + result);
		System.out.println("Actual vala" + user);
		if (result) {
			return "/userpages/userexistpage";
		}

		return "/userpages/userlogin";
	}

	@GetMapping("/logout")
	public String logout() {
		return "/quizpages/logoutpage";
	}

	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFoundException() {
		return "userpages/usernotfoundpage";
	}

}
