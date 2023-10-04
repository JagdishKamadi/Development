package com.epam.quiz.controller;

import com.epam.quiz.exception.QuestionNotFoundException;
import com.epam.quiz.model.Question;
import com.epam.quiz.model.QuestionTag;
import com.epam.quiz.service.CreateQuizServiceImpl;
import com.epam.quiz.service.QuestionValidationServiceImpl;
import com.epam.quiz.utility.enm.QuestionDifficultyTag;
import com.epam.quiz.utility.enm.QuestionTopicTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quizupdate")
public class QuizUpdateController {

	@Autowired
	private QuestionValidationServiceImpl questionValidationServiceImpl;
	
	@Autowired
	private CreateQuizServiceImpl createQuizServiceImpl;
	
	@Autowired
	private SectionTagList sectionTagList;
	

	
	@PostMapping("/savequestion")
	public ModelAndView saveQuestion(@ModelAttribute Question question,@RequestParam("questiontopic") String questiontopic,
	@RequestParam("questiondifficulty") String questiondifficulty,Model model)
	{
	  QuestionTag questionTag = new QuestionTag(QuestionTopicTag.valueOf(questiontopic),QuestionDifficultyTag.valueOf(questiondifficulty));
	   question.setQuestionTag(questionTag);
	   model.addAttribute("question", question);
	   questionValidationServiceImpl.addQuestionChecker(question);
		
		ModelAndView md = new ModelAndView();
		md.setViewName("adminpages/adminpage");
	
		return md;
	}
	
	@RequestMapping("/removequestion")
	public String removeQuestion(@RequestParam("questionid") String questionId)
	{
		Integer id = Integer.parseInt(questionId);
		boolean result = questionValidationServiceImpl.deleteQuestionChecker(id);
		if(!result)
		{

			throw new QuestionNotFoundException();
		}
		
		return "adminpages/adminpage";
	}
	
	@RequestMapping("/checkquestion")
	public String checkUpdateQuestionNumber(@RequestParam("questionid") String questionId,Model model)
	{
		boolean result = questionValidationServiceImpl.isQuestionNumberPresentChecker(Integer.parseInt(questionId));
		if(!result)
		{

			throw new QuestionNotFoundException();
		}
		
		model.addAttribute("sectionnamelist", sectionTagList.getAvailableQuestionSectionName());
		model.addAttribute("questiontopicnamelist", sectionTagList.getAvailableQuestionTopicTag());
		model.addAttribute("questiondifficultynamelist", sectionTagList.getAvailableQuestionDifficultyTag());
		
		Question question = questionValidationServiceImpl.getQuestionById(Integer.parseInt(questionId));
		model.addAttribute("questionid", questionId);
		model.addAttribute("question", question);
		
		return "/updatequiz/updatequestion";
	}
	
	
	
	@PostMapping("/updatequestion")
	public ModelAndView updateQuestion(@RequestParam("questionid") String questionId,
			@RequestParam("questionDescription") String questionDescription,
			@RequestParam("option1") String option1,
			@RequestParam("option2") String option2,
			@RequestParam("option3") String option3,
			@RequestParam("option4") String option4,
			@RequestParam("answer") String answer,
			@RequestParam("sectionName") String sectionName,
			@RequestParam("questiontopic") String questiontopic,
			@RequestParam("questiondifficulty") String questiondifficulty
			)
	{
		 Integer id = Integer.parseInt(questionId);
		 Question question = new Question(questionDescription,option1,option2,option3,option4,answer);
		 question.setSectionName(sectionName);
		 QuestionTag questionTag = new QuestionTag(QuestionTopicTag.valueOf(questiontopic),QuestionDifficultyTag.valueOf(questiondifficulty));
		 question.setQuestionTag(questionTag);
	     questionValidationServiceImpl.updateQuestionChecker(id, question);
	     
		ModelAndView md = new ModelAndView();
		md.setViewName("adminpages/adminpage");
	
		return md;
	}
	
	@RequestMapping("/getsectionpage")
	public ModelAndView getSectionPage(@RequestParam("sectionname") String sectionName)
	{
		ModelAndView md = new ModelAndView();
		md.addObject("sectionname",sectionName);
		md.addObject("sectionnamequestion",createQuizServiceImpl.getQuestionNumberListBySectionName(sectionName));
		md.setViewName("/sectionpages/sectionpage");
		return md;
	}
	
	
	
	@ExceptionHandler(QuestionNotFoundException.class)
	public String questionNotFoundHanlder()
	{
		return "/updatequiz/questionnotfoundexception";
	}
}
