package com.epam.quiz.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {
	
	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFoundHandler() {
		return "nullpage";
	}

	@ExceptionHandler(QuestionNotFoundException.class)
	public String questionNotFoundHandler()
	{
		return "/updatequiz/questionnotfoundexception";
	}

	@ExceptionHandler(UserExistException.class)
	public String userExistHandlerHandler()
	{
		return "/userpages/userexistpage";
	}
}
