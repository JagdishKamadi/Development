package com.epam.quiz.controller;

import com.epam.quiz.service.CreateQuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/adminquiz")
public class AdminQuizController {

	@Autowired
	private SectionTagList sectionTagList;
	
	@Autowired
	private CreateQuizServiceImpl createQuizServiceImpl;

	
	@GetMapping("/operation")
	public ModelAndView quizOperation(@RequestParam("optionchoice") String choice) {
		
		ModelAndView md = new ModelAndView();
		md.addObject("sectionnamelist", sectionTagList.getAvailableQuestionSectionName());
		md.addObject("questiontopicnamelist", sectionTagList.getAvailableQuestionTopicTag());
		md.addObject("questiondifficultynamelist", sectionTagList.getAvailableQuestionDifficultyTag());
		md.addObject("choice", choice);
		md.addObject("sectionnamelist",sectionTagList.getAvailableQuestionSectionName());	
		md.addObject("sectionlistquestion",createQuizServiceImpl.getAllQuestionList());
		md.setViewName(getPageBasedOnChoice(Integer.parseInt(choice)));
		return md;
	}


	private String getPageBasedOnChoice(final Integer choice) {

		Map<Integer, String> pageMap = new HashMap<>();
		pageMap.put(1, "updatequiz/addnewquestion");
		pageMap.put(2, "updatequiz/removequestion");
		pageMap.put(3, "updatequiz/updatequestionchecker");
		pageMap.put(4, "updatequiz/showquestion");
		pageMap.put(5, "updatequiz/addnewsectiontag");
		pageMap.put(6, "updatequiz/updatesectionchecker");
		return pageMap.get(choice);
	}
}
